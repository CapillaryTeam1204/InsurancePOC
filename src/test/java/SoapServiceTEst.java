
import integratorConnections.soapServiceCalls.SoapServiceCall;
import io.restassured.response.Response;
import utilities.Constants;
import utilities.GenericXmlParser;
import utilities.SaveServiceCallResponse;
import utilities.WriteResponseInExcel;
import utilities.XmlBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import insurance.InsuranceXMLConstants;

public class SoapServiceTEst {
    public static void main(String args[]) throws IOException, ParserConfigurationException, TransformerException {
    	
    	HashMap<String, LinkedList<String>> map;
    	HashMap<String,String> columnmap;
    	
        XSSFSheet sheet = ReadInputData.wrkBook.getSheet(Constants.inputSheets[0]);
		for(int row=1;row<=sheet.getLastRowNum();row++) {
    	   	   	
            //Making a SOAP Call    	
            SoapServiceCall srCall = new SoapServiceCall(Constants.ENDPOINTURL_SOAP);
            Map<String,String> pathParams= new HashMap<String,String>();
            Response response=srCall.soapServiceCall(pathParams);
            SaveServiceCallResponse saveServiceCallResponse = new  SaveServiceCallResponse(response.getBody().asString());
            saveServiceCallResponse.saveResponse();
            System.out.println(response.getStatusCode());
            System.out.println(response.body().asString());

            //Parse the response
            GenericXmlParser parser = new GenericXmlParser(Constants.INPUTFILELOCATION_XML);
            map = parser.xmlParser();

            //Taking the columns needed for Excel        
            InsuranceXMLConstants insuranceXMLConstants = new InsuranceXMLConstants();
            columnmap = insuranceXMLConstants.columnExportMap();


            //Write the response in Excel
            WriteResponseInExcel writeResponseInExcel = new WriteResponseInExcel(map, columnmap);
            writeResponseInExcel.writeAllResponseInExcel();
        }      
        
    }
}

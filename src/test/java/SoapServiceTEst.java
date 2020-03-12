
import integratorConnections.soapServiceCalls.SoapServiceCall;
import io.restassured.response.Response;
import utilities.Constants;
import utilities.GenericXmlParser;
import utilities.ReadInputData;
import utilities.SaveServiceCallResponse;
import utilities.WriteResponseInExcel;
import utilities.XmlBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import insurance.InsuranceXMLConstants;

public class SoapServiceTEst {
    public static void main(String args[]) throws IOException, ParserConfigurationException, TransformerException {
    	
    	HashMap<String, LinkedList<String>> map;
    	HashMap<String,String> columnmap;
    	ReadInputData.openWorkbook();
		Constants.rd= new ReadInputData();
        XSSFSheet sheet = ReadInputData.wrkBook.getSheet(Constants.inputSheets[0]);
        Constants.rowCount=sheet.getLastRowNum();
		for(Constants.row=1;Constants.row<=sheet.getLastRowNum();Constants.row++) {
    	   	
			//XML Generator
			XmlBuilder xmlGen = new XmlBuilder();
			xmlGen.xmlGenerator();
			
            //Make a Rating service call   	
            SoapServiceCall srCall = new SoapServiceCall(Constants.ENDPOINTURL_SOAP);
            Map<String,String> pathParams= new HashMap<String,String>();
            Response response=srCall.soapServiceCall(pathParams);
            SaveServiceCallResponse saveServiceCallResponse = new  SaveServiceCallResponse(response.getBody().asString());
            saveServiceCallResponse.saveResponse();
            System.out.println(response.getStatusCode());
            System.out.println(response.body().asString());

            //Parse the response received from Rating engine
            GenericXmlParser parser = new GenericXmlParser(Constants.INPUTFILELOCATION_XML);
            map = parser.xmlParser();

          //Write the response to Excel
            InsuranceXMLConstants insuranceXMLConstants = new InsuranceXMLConstants();
            columnmap = insuranceXMLConstants.columnExportMap();            
            WriteResponseInExcel writeResponseInExcel = new WriteResponseInExcel(map, columnmap);
            writeResponseInExcel.writeReqResponseInExcel();
        }      
        
    }
}

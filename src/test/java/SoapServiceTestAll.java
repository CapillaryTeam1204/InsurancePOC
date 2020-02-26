import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import insurance.InsuranceXMLConstants;
import integratorConnections.soapServiceCalls.SoapServiceCall;
import io.restassured.response.Response;
import utilities.Constants;
import utilities.GenericXmlParser;
import utilities.SaveServiceCallResponse;
import utilities.WriteResponseInExcel;

public class SoapServiceTestAll {

	public static void main(String[] args) throws IOException {
		HashMap<String, LinkedList<String>> map;
    	HashMap<String,String> columnmap;
    	
    	
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
        writeResponseInExcel.writeReqResponseInExcel();
        
        System.out.println("************Execution Completed************");
        

	}

}

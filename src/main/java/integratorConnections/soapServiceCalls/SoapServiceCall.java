package integratorConnections.soapServiceCalls;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Constants;
import utilities.ReadValuesFromFile;

import java.util.Map;

public class SoapServiceCall {
    public static RequestSpecification request;
    public static String serviceBody;

    public SoapServiceCall(String url){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        ReadValuesFromFile fileValues= new ReadValuesFromFile(Constants.INPUTFILELOCATION_SOAPCALL);
        serviceBody=fileValues.readFromfile();
        builder.setBaseUri(url);
        if(!serviceBody.equals("")){
            builder.setBody(serviceBody);
        }
        builder.addHeader(Constants.SOAP_ACTION,Constants.FIND_SOAP_ACTION);
        RequestSpecification requestSpec= builder.build();
        request= RestAssured.given().spec(requestSpec);
    }
    public Response soapServiceCall( Map<String,String> pathParams){
        Response response=null;
        request.pathParams(pathParams);
        request.contentType(ContentType.XML);
        request.accept(ContentType.XML);
        response= request.post().thenReturn();
        return response;
    }
}

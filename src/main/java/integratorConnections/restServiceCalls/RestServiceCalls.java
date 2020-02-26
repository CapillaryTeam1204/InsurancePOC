package integratorConnections.restServiceCalls;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Constants;
import utilities.ReadValuesFromFile;
import utilities.TypeChecker;
import java.util.Map;


public class RestServiceCalls {
    public static RequestSpecification request;
    public static String serviceBody;

    public RestServiceCalls(String url){
        RequestSpecBuilder builder = new RequestSpecBuilder();
        ReadValuesFromFile fileValues= new ReadValuesFromFile(Constants.INPUTFILELOCATION_RESTCALL);
        serviceBody=fileValues.readFromfile();
        builder.setBaseUri(url);
        if(!serviceBody.equals("")){
            builder.setBody(serviceBody);
        }
        RequestSpecification requestSpec= builder.build();
        request=RestAssured.given().spec(requestSpec);
    }

    public Response restServiceCall(String callType, Map<String,String> pathParams){
        Response response=null;
        TypeChecker typeCheck= new TypeChecker();
        switch (callType){
            case Constants.POSTCALL :
                request.pathParams(pathParams);
                request=typeCheck.jsonAndXmlChecker(serviceBody,request);
                response= request.post().thenReturn();
               break;
            case Constants.PUTCALL :
                request.pathParams(pathParams);
                request=typeCheck.jsonAndXmlChecker(serviceBody,request);
                response= request.put().thenReturn();
                break;
            case Constants.GETCALL :
                break;
            case Constants.DELETECALL:
                break;
        }
        return response;

    }


}

import integratorConnections.restServiceCalls.RestServiceCalls;
import io.restassured.response.Response;
import utilities.Constants;
import utilities.ReadValuesFromFile;

import java.util.HashMap;
import java.util.Map;

public class RestServiceTest {

    public static void main(String args[]){
        RestServiceCalls srCall= new RestServiceCalls(Constants.ENDPOINTURL_UPDATE);
        Map<String,String> pathParams= new HashMap<String,String>();
        Response response=srCall.restServiceCall( Constants.PUTCALL, pathParams);
        System.out.println(response.getStatusCode());
    }

}

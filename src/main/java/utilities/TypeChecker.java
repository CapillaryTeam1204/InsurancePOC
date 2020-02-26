package utilities;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;

public class TypeChecker {

    public RequestSpecification jsonAndXmlChecker(String input, RequestSpecification request){
        boolean isJon=false;
        try{
            JSONObject o = new JSONObject(input);
            isJon=true;
        }catch (JSONException e) {

        }
        if(isJon){
            request.contentType(ContentType.JSON);
            request.accept(ContentType.JSON);
        }else if(input.startsWith("<")){
            request.contentType(ContentType.XML);
            request.accept(ContentType.XML);
        }

        return request;
    }


}

package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveServiceCallResponse {
	
	private String responseContent;


	public SaveServiceCallResponse (String responseContent) {
		this.responseContent = responseContent;
	}
	
	
	public void saveResponse() {
		
		String projectPath = System.getProperty("user.dir");
		String path = projectPath + "/src/main/resources/OutputFiles/ResponseXMl.xml";
		
		 try (FileWriter writer = new FileWriter(path);
	              BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			 	  bufferedWriter.write(responseContent);
			 	  } catch (IOException e) {
			 		 e.printStackTrace();
			 	  }			 		  
	        
	}

}

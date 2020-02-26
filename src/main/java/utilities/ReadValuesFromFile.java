package utilities;

import org.junit.Assert;

import java.io.*;

public class ReadValuesFromFile {
    public String fileLocation;
    public ReadValuesFromFile(String fileLocation){
        this.fileLocation=fileLocation;
    }

    public String readFromfile() {
        try{
            String finalString="";
            InputStream is = new FileInputStream(fileLocation);
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));
            String line = buf.readLine(); StringBuilder sb = new StringBuilder();
            while(line != null){
                sb.append(line).append("\n");
                line = buf.readLine();
            }
            finalString = sb.toString();
            return finalString.trim();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail("Failed to read from file");
            return null;
        }

     }


}

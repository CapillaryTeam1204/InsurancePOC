package utilities;

import java.io.File;
import java.util.HashMap;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class XMLParser {
    String fileName;
    public XMLParser(String filename){
        this.fileName=filename;
    }

    public void xmlParser(String tagForValueNeeded) throws Exception{
        HashMap<String,String> resultMap= new  HashMap<String,String>();
        Document document;
        DocumentBuilder builder;
        DocumentBuilderFactory factory;
        Element elementDetail, eElement;
        String[] inputValues = tagForValueNeeded.split(Pattern.quote(Constants.DOT_OPERATOR));
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(new File(fileName));
        document.getDocumentElement().normalize();
        ParserHelper prHlp= new ParserHelper(document);
        resultMap=(inputValues.length > 1) ? prHlp.getValuesWithMorethanOneParametersFromUser(inputValues) :
                        prHlp.getValuesWithOneParameterFromUser(inputValues);
            prHlp.getValuesWithMorethanOneParametersFromUser(inputValues);
            System.out.println(resultMap);

    }

    public static void main(String args[]) throws Exception {
        XMLParser xmlp= new XMLParser(Constants.INPUTFILELOCATION_XML);
        xmlp.xmlParser("policyDrivers.dateOfBirth");

    }
}

package utilities;

import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import insurance.InsuranceXMLConstants;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class GenericXmlParser {

	String documentPath;
	DocumentBuilderFactory docBuilderFactory;
	DocumentBuilder docBuilder;
	Document document;
	HashMap<String,String>columnMapper;	
	HashMap<String,LinkedList<String>> newMap;
	

	public GenericXmlParser(String documentPath) {
		this.documentPath = documentPath;
	}

	public HashMap<String, LinkedList<String>> xmlParser() {
		try {
			//LinkedList<String> finalList = new LinkedList<String>();
			//HashMap<String, LinkedList<String>> newMap = new HashMap<String, LinkedList<String>>();
			docBuilderFactory = DocumentBuilderFactory.newInstance();
			docBuilder = docBuilderFactory.newDocumentBuilder();
			document = docBuilder.parse(new File(documentPath));
			String root = document.getDocumentElement().getNodeName();
			NodeList nodeList = document.getElementsByTagName(Constants.STAR_OPERATOR);
			newMap = ParserHelper.getAllElementsIntheXML(nodeList, root);					
			/*
			 * InsuranceXMLConstants insuranceXMLConstants = new
			 * InsuranceXMLConstants(columnMapper); columnMapper =
			 * insuranceXMLConstants.columnExportMap(); WriteResponseInExcel
			 * writeResponseInExcel = new WriteResponseInExcel(newMap,columnMapper);
			 * writeResponseInExcel.writeReqResponseInExcel();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Failed to parse the document, please refer the stacktrance for more details");
		}
		
		return newMap;
	}


}

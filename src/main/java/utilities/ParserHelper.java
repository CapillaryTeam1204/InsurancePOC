package utilities;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class ParserHelper {

    Document document;
    Element elementDetail, eElement;

    public ParserHelper(Document document) {
        this.document = document;
    }

    public static String getParentTag(Node node, String rootElement) {
        String parentPath = "";
        String finalParentPath = "";
        Node newNode = node;
        while (!(newNode.getNodeName().equalsIgnoreCase(rootElement))) {
            newNode = newNode.getParentNode();
            parentPath = parentPath + "." + newNode.getNodeName();
        }
        parentPath = parentPath.replaceFirst(".", "");
        String[] arryParentPth = parentPath.split("[.]");
        for (int i = arryParentPth.length - 1; i >= 0; i--) {
            finalParentPath = finalParentPath + "." + arryParentPth[i];
        }
        finalParentPath = finalParentPath.replaceFirst(".", "");
        return finalParentPath+"."+node.getNodeName();
    }

    public static HashMap<String, LinkedList<String>> getAllElementsIntheXML(NodeList nodeList, String root) {
        LinkedList<String> finalList = new LinkedList<String>();
        HashMap<String, String> resultMap = new HashMap<String, String>();
        HashMap<String, LinkedList<String>> newMap = new HashMap<String, LinkedList<String>>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                try {
                    if (!(node.getFirstChild().getTextContent().trim().equals(Constants.NULLSTRING))) {
                        String parentPath = ParserHelper.getParentTag(node, root);
                        LinkedList<String> listArry = new LinkedList<String>();
                        if (newMap.containsKey(parentPath)) {
                            listArry = newMap.get(parentPath);
                            String newVl = node.getTextContent();
                            listArry.add(newVl);
                            newMap.put(parentPath, listArry);

                        } else {
                            listArry.add(node.getTextContent());
                            newMap.put(parentPath, listArry);

                        }
//                        resultMap.put(parentPath + Constants.DOT_OPERATOR + node.getNodeName(), node.getTextContent());
//                        finalList.add(parentPath + Constants.DOT_OPERATOR + node.getNodeName() + "=" + node.getTextContent());
                    }
                } catch (NullPointerException e) {
                    continue;
                }
            }
           System.out.println(newMap);
        }
        return newMap;
    }

    /**********************************************************************/
    public HashMap<String, String> getValuesWithMorethanOneParametersFromUser(String[] inputValues) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        NodeList nodeList = document.getElementsByTagName(inputValues[0]);

        for (int i = 0; i < nodeList.getLength(); i++) {
            elementDetail = (Element) nodeList.item(i);
            eElement = (Element) elementDetail.getChildNodes();
            resultMap.put(eElement.getParentNode().getNodeName() + "." + inputValues[0] + "." + inputValues[1], eElement.getElementsByTagName(inputValues[1]).item(i).getTextContent());
        }
        return resultMap;
    }

    public HashMap<String, String> getValuesWithOneParameterFromUser(String[] inputValues) {
        HashMap<String, String> resultMap = new HashMap<String, String>();
        NodeList children = document.getElementsByTagName(inputValues[0]);
        for (int i = 0; i < children.getLength(); i++) {
            elementDetail = (Element) children.item(i);
            if (!elementDetail.hasChildNodes()) {
                resultMap.put(elementDetail.getParentNode().getParentNode().getNodeName() + "." + elementDetail.getParentNode().getNodeName() + "." + elementDetail.getNodeName(), elementDetail.getTextContent());
            } else {
                System.out.println("Node doesnt have any value persay, but has child values");

            }
        }
        return resultMap;
    }


}

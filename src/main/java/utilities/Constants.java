package utilities;

import java.io.File;

public class Constants {

    public static final String ENDPOINTURL_CREATE ="http://dummy.restapiexample.com/api/v1/create";
    public static final String ENDPOINTURL_UPDATE ="http://dummy.restapiexample.com/api/v1/update/21";
    public static final String ENDPOINTURL_SOAP ="http://127.0.0.1:8088/mockServiceSoapBinding";
    public static final String POSTCALL="POST";
    public static final String PUTCALL="PUT";
    public static final String GETCALL="GET";
    public static final String DELETECALL="DELETE";
    public static final String LINESEPARATOR = File.separator;
    public static final String INPUTFILELOCATION_RESTCALL =(System.getProperty("user.dir")+ LINESEPARATOR +"src"+ LINESEPARATOR +"main"+ LINESEPARATOR +"resources"+ LINESEPARATOR +"InputFiles"+ LINESEPARATOR +"RestServiceRequest");
    public static final String INPUTFILELOCATION_SOAPCALL =(System.getProperty("user.dir")+ LINESEPARATOR +"src"+ LINESEPARATOR +"main"+ LINESEPARATOR +"resources"+ LINESEPARATOR +"InputFiles"+ LINESEPARATOR +"SoapServiceRequest");
    public static final String INPUTFILELOCATION_XML =(System.getProperty("user.dir")+ LINESEPARATOR +"src"+ LINESEPARATOR +"main"+ LINESEPARATOR +"resources"+ LINESEPARATOR +"OutputFiles"+ LINESEPARATOR +"ResponseXMl.xml");    
    public static final String SOAP_ACTION="SOAPAction";
    public static final String FIND_SOAP_ACTION="findSoapAction";
    public static final String EQUAL_OPERATOR ="=";
    public static final String NULLSTRING="";
    public static final String STAR_OPERATOR="*";
    public static final String DOT_OPERATOR=".";
    public static final String[] inputSheets = {"Rating"};
    public static String TS_Num="";
}

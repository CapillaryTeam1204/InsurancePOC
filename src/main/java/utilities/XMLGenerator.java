package utilities;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLGenerator {

    public static final String xmlFilePath =Constants.INPUTFILELOCATION_XML;
    public static DocumentBuilderFactory factory;
    public static DocumentBuilder builder;
    public static Document doc;
    public static Element dummyElement;

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();

        Element rootElement = doc.createElement("policyPeriod");
        doc.appendChild(rootElement);

        dummyElement = createChild("periodStart", "2019-11-07", rootElement);
        dummyElement = createChild("tracsactionType", "Submission", rootElement);
        Element personalAutoLine = createChild("periodStart", "", rootElement);
        dummyElement = createChild("publicID", "pc:1", personalAutoLine);
        Element personalVehicles = createChild("personalVehicles", "", personalAutoLine);

        createCoverage("One", "Comprehensive", "DeductibleAmount", "500", null, null, null, null, personalVehicles);
        createCoverage("One", "Collision", "DeductibleAmount", "500", null, null, null, null, personalVehicles);

        dummyElement = createChild("isDssEnrolled", "false", personalVehicles);
        dummyElement = createChild("totalCustomizationAmount", "0.00", personalVehicles);
        dummyElement = createChild("primaryUse", "Business", personalVehicles);
        dummyElement = createChild("vin", "VIN1234567890", personalVehicles);
        dummyElement = createChild("year", "2010", personalVehicles);
        dummyElement = createChild("bodyType", "4d 2.5 SL", personalVehicles);
        dummyElement = createChild("model", "Altima", personalVehicles);
        dummyElement = createChild("make", "Nissan", personalVehicles);
        dummyElement = createChild("vehicleSafetyDiscountCode", "D", personalVehicles);
        dummyElement = createChild("collisionIRGCode", "014", personalVehicles);
        dummyElement = createChild("comprehensiveIRGCode", "014", personalVehicles);
        dummyElement = createChild("publicID", "pc:1", personalVehicles);
        dummyElement = createChild("customVehicleSwitch", "false", personalVehicles);
        Element vehicleRegisteredOwners = createChild("vehicleRegisteredOwners", "", personalVehicles);
        dummyElement = createChild("clientIdentifier", "RMGR29FSPYC", vehicleRegisteredOwners);
        Element garageLocation = createChild("garageLocation", "", personalVehicles);
        dummyElement = createChild("addressLine1", "1056 Hummingbird way", garageLocation);
        dummyElement = createChild("city", "Bloomington", garageLocation);
        dummyElement = createChild("cityCode", "123", garageLocation);
        dummyElement = createChild("countyCode", "456", garageLocation);
        dummyElement = createChild("countyName", "McLean", garageLocation);
        dummyElement = createChild("latitude", "40.0057", garageLocation);
        dummyElement = createChild("locationMatchCode", "S00", garageLocation);
        dummyElement = createChild("locationQualityCode", "AP05", garageLocation);
        dummyElement = createChild("longitude", "-83.0090", garageLocation);
        dummyElement = createChild("postalCode", "61704", garageLocation);
        dummyElement = createChild("state", "IL", garageLocation);
        dummyElement = createChild("kitCarIndicator", "false", personalVehicles);
        dummyElement = createChild("transportationNetworkCompanyIndicator", "false", personalVehicles);
        dummyElement = createChild("transportationIncidentalOccupationDutyIndicator", "false", personalVehicles);
        dummyElement = createChild("transportationSchoolChurchEmployeeIndicator", "false", personalVehicles);
        dummyElement = createChild("vehicleTenureDate", "2019-11-07", personalVehicles);

        createCoverage("One", "MedicalPayments", "LimitPerPersonAmount", "5000", null, null, null, null,
                personalAutoLine);
        createCoverage("Two", "UninsuredBodilyInjury", "LimitPerPersonAmount", "25000", "LimitPerAccidentAmount",
                "50000", null, null, personalAutoLine);
        createCoverage("Three", "BodilyInjuryAndPropertyDamage", "BodilyInjuryLimitPerPersonAmount", "25000",
                "BodilyInjuryLimitPerAccidentAmount", "50000", "PropertyDamageLimitPerAccidentAmount", "25000",
                personalAutoLine);

        Element policyDrivers = createChild("policyDrivers", "", personalAutoLine);
        dummyElement = createChild("dateOfBirth", "1990-01-01", policyDrivers);
        dummyElement = createChild("clientIdentifier", "RMGR29FSPYC", policyDrivers);
        dummyElement = createChild("subType", "PolicyDriver", policyDrivers);
        dummyElement = createChild("firstName", "TestFirstName", policyDrivers);
        dummyElement = createChild("lastName", "TestLastName", policyDrivers);
        dummyElement = createChild("militaryDriverSwitch", "false", policyDrivers);
        dummyElement = createChild("militaryFrequentVehicleAccessSwitch", "true", policyDrivers);
        dummyElement = createChild("gender", "M", policyDrivers);
        dummyElement = createChild("originalLicenseDate", "2010-01-01", policyDrivers);
        dummyElement = createChild("licensedType", "US_SF", policyDrivers);
        dummyElement = createChild("employeeDriverSwitch", "false", policyDrivers);
        dummyElement = createChild("driverTenureStartDate", "2019-11-07", policyDrivers);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSOurce = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
        transformer.transform(domSOurce, streamResult);
    }

    public static Element createChild(String tagName, String tagValue, Element parentNode) {
        Element ele = doc.createElement(tagName);
        ele.appendChild(doc.createTextNode(tagValue));
        parentNode.appendChild(ele);
        return ele;
    }

    public static void createCoverage(String NoOfCvgTerms, String patternCode, String termName1, String termValue1,
                                      String termName2, String termValue2, String termName3, String termValue3, Element parentNode) {

        switch (NoOfCvgTerms) {
            case "One":
                Element onePersonalCoverages = createChild("personalCoverages", "", parentNode);
                dummyElement = createChild("patternCode", patternCode, onePersonalCoverages);
                Element oneCoverageTerms1 = createChild("coverageTerms", "", onePersonalCoverages);
                dummyElement = createChild("termName", termName1, oneCoverageTerms1);
                dummyElement = createChild("termValue", termValue1, oneCoverageTerms1);

                break;

            case "Two":
                Element twoPersonalCoverages = createChild("personalCoverages", "", parentNode);
                dummyElement = createChild("patternCode", patternCode, twoPersonalCoverages);
                Element twoCoverageTerms1 = createChild("coverageTerms", "", twoPersonalCoverages);
                dummyElement = createChild("termName", termName1, twoCoverageTerms1);
                dummyElement = createChild("termValue", termValue1, twoCoverageTerms1);
                Element twoCoverageTerms2 = createChild("coverageTerms", "", twoPersonalCoverages);
                dummyElement = createChild("termName", termName1, twoCoverageTerms2);
                dummyElement = createChild("termValue", termValue1, twoCoverageTerms2);

                break;

            case "Three":
                Element threePersonalCoverages = createChild("personalCoverages", "", parentNode);
                dummyElement = createChild("patternCode", patternCode, threePersonalCoverages);
                Element threeCoverageTerms1 = createChild("coverageTerms", "", threePersonalCoverages);
                dummyElement = createChild("termName", termName1, threeCoverageTerms1);
                dummyElement = createChild("termValue", termValue1, threeCoverageTerms1);
                Element threeCoverageTerms2 = createChild("coverageTerms", "", threePersonalCoverages);
                dummyElement = createChild("termName", termName1, threeCoverageTerms2);
                dummyElement = createChild("termValue", termValue1, threeCoverageTerms2);
                Element threeCoverageTerms3 = createChild("coverageTerms", "", threePersonalCoverages);
                dummyElement = createChild("termName", termName1, threeCoverageTerms3);
                dummyElement = createChild("termValue", termValue1, threeCoverageTerms3);
                break;

            default:
                break;
        }

    }
}

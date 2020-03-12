package insurance;

import java.util.HashMap;

public class InsuranceXMLConstants {

private HashMap<String,String> columnMapper;
	
	
	/*
	 * public InsuranceXMLConstants(HashMap<String,String>columnMapper) {
	 * this.columnMapper = columnMapper; }
	 */
	 
	
	public HashMap<String,String> columnExportMap() {
		columnMapper= new HashMap<String,String>();
		columnMapper.put("POLICY_PERIOD_START","policyPeriod.periodStart");
		columnMapper.put("PERSONALCOVERG_VIN", "policyPeriod.periodStart.personalVehicles.vin");
		columnMapper.put("PERSONALCOVERG_MODEL", "policyPeriod.periodStart.personalVehicles.model");		
		columnMapper.put("PERSONALVEHC_PREMIUM_AMOUNT","policyPeriod.periodStart.policyPremium.premium");
	
		
		return columnMapper;
		//columnMapper.put("PERSONALVEHC_COVERG_COVERGECODE", "policyPeriod.periodStart.personalVehicles.personalCoverages.coveragePremiums.cvgCode");
		//columnMapper.put("PERSONALVEHC_COVERG_TERMVALUE","policyPeriod.periodStart.personalVehicles.personalCoverages.coveragePremiums.termValue");		
		//columnMapper.put("PERSONALVEHC_COVERG_TERMNAME","policyPeriod.periodStart.personalVehicles.personalCoverages.coveragePremiums.termName");
		//columnMapper.put("PERSONALCOVERG_TERMVALUE", "policyPeriod.periodStart.personalCoverages.coverageTerms.termValue");
		//columnMapper.put("PERSONALCOVERG_TERMNAME","policyPeriod.periodStart.personalCoverages.coverageTerms.termName");
		
	}

    /*
	public static final String POLICY_PERIOD_START="policyPeriod.periodStart";
    public static final String KITCAR_IND="policyPeriod.periodStart.personalVehicles.kitCarIndicator";
    public static final String PERSONALVEHC_GARAGELOC_COUNTYNAME="policyPeriod.periodStart.personalVehicles.garageLocation.countyName";
    public static final String PERSONALVEHC_GARAGELOC_LATITUDE="policyPeriod.periodStart.personalVehicles.garageLocation.latitude";
    public static final String PERSONALVEHC_GARAGELOC_CITYCODE=" policyPeriod.periodStart.personalVehicles.garageLocation.cityCode";
    public static final String PERSONALVEHC_GARAGELOC_LOCTNQTY_CODE="policyPeriod.periodStart.personalVehicles.garageLocation.locationQualityCode";
    public static final String PERSONALVEHC_GARAGELOC_LOCTN_STATE="policyPeriod.periodStart.personalVehicles.garageLocation.state";
    public static final String PERSONALVEHC_GARAGELOC_LOCTN_CITY="policyPeriod.periodStart.personalVehicles.garageLocation.city";
    public static final String PERSONALVEHC_BODYTYPE="policyPeriod.periodStart.personalVehicles.bodyType";
    public static final String PERSONALVEHC_MODEL="policyPeriod.periodStart.personalVehicles.model";
    public static final String PERSONALVEHC_MAKE="policyPeriod.periodStart.personalVehicles.make";
    public static final String PERSONALVEHC_CUSTM_VEHCSWITCH="policyPeriod.periodStart.personalVehicles.customVehicleSwitch";
    public static final String PERSONALVEHC_COVERG_TERMVALUE="policyPeriod.periodStart.personalVehicles.personalCoverages.coverageTerms.termValue";
    public static final String PERSONALVEHC_COVERG_TERMNAME="policyPeriod.periodStart.personalVehicles.personalCoverages.coverageTerms.termName";
    public static final String PERSONALVEHC_COVERG_PATERN_CODE="policyPeriod.periodStart.personalVehicles.personalCoverages.patternCode";
    public static final String PERSONALVEHC_TRANSPORTATN_CMPNY_IND="policyPeriod.periodStart.personalVehicles.transportationNetworkCompanyIndicator";
    public static final String PERSONALVEHC_TRANSPORTATN_SCHLCHRUCH_IND="policyPeriod.periodStart.personalVehicles.transportationSchoolChurchEmployeeIndicator";
    public static final String PERSONALVEHC_COMPREHENSIVE_IRGCODE="policyPeriod.periodStart.personalVehicles.comprehensiveIRGCode";
    public static final String PERSONALVEHC_VECH_TENURE_DATE="policyPeriod.periodStart.personalVehicles.vehicleTenureDate";
    public static final String PERSONALVEHC_TOTALCUSTOM_AMT="policyPeriod.periodStart.personalVehicles.totalCustomizationAmount";
    public static final String PERSONALVEHC_TRANSPTN_INCIDNTOCCUPTNDTY_IND="policyPeriod.periodStart.personalVehicles.transportationIncidentalOccupationDutyIndicator";
    public static final String PERSONALVEHC_REGISTRD_OWNR_CLIENT_IND="policyPeriod.periodStart.personalVehicles.vehicleRegisteredOwners.clientIdentifier";
    public static final String PERSONALCOVERG_TERMVALUE="policyPeriod.periodStart.personalCoverages.coverageTerms.termValue";
    public static final String PERSONALCOVERG_TERMNAME="policyPeriod.periodStart.personalCoverages.coverageTerms.termName";
    public static final String POLICYDRIVER_TENURE_STARTDATE="policyPeriod.periodStart.policyDrivers.driverTenureStartDate";
    public static final String POLICYDRIVER_MILITARY_DRIVER_SWITCH="policyPeriod.periodStart.policyDrivers.militaryDriverSwitch";
    public static final String POLICYDRIVER_LICENSE_TYP="policyPeriod.periodStart.policyDrivers.licensedType";
	*/

}

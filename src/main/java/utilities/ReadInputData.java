package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.SetterAndGetter;

public class ReadInputData {
	static XSSFWorkbook wrkBook;
	Row row;
	Map<String, Integer> col;
	static SetterAndGetter st = new SetterAndGetter();
	
	public static void openWorkbook() throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + "InputFiles" + File.separator + "input-to-xml.xlsx"));
			wrkBook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}		
	}

	public SetterAndGetter readSheet(String sheetName, int rowNo) {		
		XSSFSheet sheet = wrkBook.getSheet(sheetName);
		int colNum = sheet.getRow(0).getLastCellNum();
		col = new HashMap<>();
	      if(sheet.getRow(0).cellIterator().hasNext()) {
	    	  for(int i=0;i<colNum;i++) {
	    		  col.put(sheet.getRow(0).getCell(i).toString(), i);
	    	  }	    	  
	      }
		row = sheet.getRow(rowNo);
		switch (sheetName) {
		case "Rating":
			st.setFirstName(row.getCell(col.get("FirstName")).toString());
			st.setLastName(row.getCell(col.get("LastName")).toString());
			st.setClientID(row.getCell(col.get("ClientID")).toString());
			st.setDob(row.getCell(col.get("DOB")).toString());
			st.setVehPrimaryUse(row.getCell(col.get("VehiclePrimaryUse")).toString());
			st.setBI_PerPerson(row.getCell(col.get("BIPerPerson")).toString());
			st.setBI_PerAccident(row.getCell(col.get("BIPerAccident")).toString());
			st.setPD_PerAccident(row.getCell(col.get("PDPerAccident")).toString());
			st.setUMBI_PerPerson(row.getCell(col.get("UMBIPerPerson")).toString());
			st.setUMBI_PerAccident(row.getCell(col.get("UMBIPerAccident")).toString());
			st.setMedPay(row.getCell(col.get("MedPay")).toString());
			st.setCOMP(row.getCell(col.get("COMP_Deductible")).toString());
			st.setCOLL(row.getCell(col.get("COLL_Deductible")).toString());
			break;
		case "Dummy1":
			st.setDummyHeader1(row.getCell(col.get("DummyHeader1")).toString());
			break;
		case "Dummy2":
			st.setDummyHeader2(row.getCell(col.get("DummyHeader2")).toString());
			break;
		default:
			break;
		}
		row=null;
		col=null;
		return st;
	}
}

package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteResponseInExcel {
	
	private HashMap<String, LinkedList<String>> map;
	private HashMap<String, String> columnmap;
	
	public WriteResponseInExcel(HashMap<String, LinkedList<String>> map, HashMap<String, String>columnmap) {
		this.map = map;
		this.columnmap = columnmap;
	}	
	
	public void writeAllResponseInExcel() throws IOException {
		
		  
	  XSSFWorkbook workbook = new XSSFWorkbook(); 
	  XSSFSheet sheet = workbook.createSheet("Output");
	  
	  Set<String> keyset = map.keySet(); 
	  Row row = sheet.createRow(0); 
	  int cellnum = 0;
	  
	  for (String key : keyset) {
		  Cell cell = row.createCell(cellnum++);
		  cell.setCellValue(key);
	  }
  
	  int celnum=0; 
	  for(Map.Entry<String, LinkedList<String>> entry :map.entrySet()) {
		  int rownum=1; 
		  for(String val: entry.getValue()) { 
			  Row row1 = sheet.getRow(rownum) == null ? sheet.createRow(rownum):sheet.getRow(rownum); Cell cell = row1.createCell(celnum);
			  cell.setCellValue(val);
			  rownum++;
		  }
		  celnum++; 
	  } 
	  String projectPath = System.getProperty("user.dir"); 
	  FileOutputStream outputFile = new FileOutputStream(projectPath + "/src/main/resources/OutputFiles/outputExport.xlsx");
	  workbook.write(outputFile);
	  outputFile.close();
	  workbook.close();	  
	}
	 
	 
	
	public void writeReqResponseInExcel() throws IOException {
			
	  XSSFWorkbook workbook = new XSSFWorkbook();
	  XSSFSheet sheet = workbook.createSheet("Output");
	    
	  Set<String> keyset = map.keySet();       
	  Row row = sheet.createRow(0);
	  int cellnum =0;      
	  for (String key : keyset) {
	  	for (Map.Entry<String,String> columnEntry : columnmap.entrySet()) { 
	   		if (columnEntry.getValue().equalsIgnoreCase(key)) {
	   			Cell cell = row.createCell(cellnum++);
	             cell.setCellValue(columnEntry.getKey());
	   		}
	   	}   
	  }
	
	  int celnum=0;
	  for(Map.Entry<String, LinkedList<String>> entry : map.entrySet()) {
		  for (Map.Entry<String,String> columnEntry : columnmap.entrySet()) {
			  if (entry.getKey().equalsIgnoreCase(columnEntry.getValue())) {
				  int rownum=1;
				  for(String val: entry.getValue()) {
					  Row row1 = sheet.getRow(rownum) == null ? sheet.createRow(rownum) :sheet.getRow(rownum);
		              Cell cell = row1.createCell(celnum);
		              cell.setCellValue(val);
		              rownum++;	            	     
		          }
		          celnum++;
		      }
		      //break;
	      }
	  }		    
	  String projectPath = System.getProperty("user.dir");
	  FileOutputStream outputFile = new FileOutputStream(projectPath + "/src/main/resources/OutputFiles/outputExport.xlsx");    	
	  workbook.write(outputFile);
	  outputFile.close();        
	  workbook.close();
	}

}

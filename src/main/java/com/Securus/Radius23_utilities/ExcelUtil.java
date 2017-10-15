package com.Securus.Radius23_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtil {

	private static FileInputStream inputStream = null;
	private static HSSFWorkbook workbook = null;
	private static HSSFSheet sheet =null;

	public ExcelUtil(String excelPath) {
		try {
			inputStream = new FileInputStream(excelPath);
			workbook = new HSSFWorkbook(inputStream);
		} catch (Exception e) {
			System.out.println("Issue in reading excel file path");
			e.printStackTrace();
		}
	}

	public static int getRowCount(String sheetName) {
		Log.log.info("Reading row count from sheet:"+sheetName);
		try{
			sheet = workbook.getSheet(sheetName);
			 int rowCount = sheet.getPhysicalNumberOfRows();
			 Log.log.info("Row count:"+rowCount);
			 return rowCount;
		}
		catch (Exception e) {
			System.out.println("Issue in reading row count from sheet:"+sheetName);
			e.printStackTrace();
			Log.log.info("Row count:"+0);
			return 0;
		}
		
	}

	public static int getColumnCount(String sheetName) {
		Log.log.info("Reading column count from sheet:"+sheetName);
		try{
			sheet = workbook.getSheet(sheetName);
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			return colCount;
		}
		catch (Exception e) {
			System.out.println("Issue in reading column count from sheet:"+sheetName);
			
			return 0;
		}
		
	}
	//Another way of writing for retrieve column count
	public static int getColumnCount(String sheetName, int rowNumber) {
		Log.log.info("Reading column count from sheet:"+sheetName+" and Row number:"+rowNumber);
		try{
			sheet = workbook.getSheet(sheetName);
			int colCount = sheet.getRow(rowNumber).getPhysicalNumberOfCells();
			Log.log.info("Column count:"+colCount);
			return colCount;
		}
		catch (Exception e) {
			System.out.println("Issue in reading column count from sheet:"+sheetName +", Row:"+rowNumber);
			Log.log.info("Column count:"+0);
			return 0;
		}
		
	}

	public static String getCellData(String sheetName, int row, int column) {
		try{
			String cellData = null;
			Sheet sheet = workbook.getSheet(sheetName);
			Row rowObject = sheet.getRow(row);
			if (rowObject == null) {
				return "";
			}
			Cell cellObject = rowObject.getCell(column);
			if (cellObject == null) {
				return "";
			}

			DataFormatter objDefaultFormat = new DataFormatter();
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		    
		    objFormulaEvaluator.evaluate(cellObject);
		    cellData = objDefaultFormat.formatCellValue(cellObject,objFormulaEvaluator);
		    return cellData;
		}
		catch (Exception e) {
			System.out.println("Issue in reading data from sheet:"+sheetName +", Row:"+row+",Column:"+column);
			return "";
		}
		
	}
	
	

	
	
	public static void main(String[] s)
	{
		
		Object[][] excelData = null;
		ExcelUtil excelUtil = new ExcelUtil("src/main/resources/TestDataFile.xls");
		List<List<String>> allRowsData = new ArrayList<List<String>>();
		int totalRowRount=excelUtil.getRowCount("Dummy");
		for (int row = 0; row < totalRowRount; row++) {
			int columnCount=0;
			List<String> rowData=new ArrayList<String>();
			if (excelUtil.getCellData("Dummy", row, 0).trim().equalsIgnoreCase("verifyingLoginWithInValidInput")) {
				columnCount=excelUtil.getColumnCount("Dummy", row); //sheetname ,rowcount
				
				for(int column=1;column<columnCount;column++)
				{
					rowData.add(excelUtil.getCellData("Dummy", row, column));
				}
				
			}
			allRowsData.add(rowData);
		}
		
		excelData = new String[allRowsData.size()][];
		int i=0;
		for(List<String> rowdata:allRowsData)
		{
			excelData[i++]=rowdata.toArray(new String[rowdata.size()]);
		}


		for(int a=0;a<excelData.length;a++)
		{
			for(int b=0;b<excelData[a].length;b++)
			{
				System.out.println(excelData[a][b]);
			}
		}
		
		
	}
	
	
	

}

package Salesforce.utilties;

import java.io.FileInputStream;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.util.NumericRanges;

public class ExcelUtility { 
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static int getRowcount(String Xlpath, String XsheetName) throws IOException {
		file = new FileInputStream(Xlpath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(XsheetName);
		int rowcount= sheet.getLastRowNum();
		return rowcount;
		
	}
	public static int getCellcount(String Xlpath, String XsheetName, int rowNum) throws IOException {
		file = new FileInputStream(Xlpath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(XsheetName);
		row = sheet.getRow(rowNum);
		int Cellcount= row.getLastCellNum();
		return Cellcount;
		
	}
	public static String getCellData(String Xlpath, String XsheetName, int rowNum, int cellNum) throws IOException {
		file = new FileInputStream(Xlpath);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(XsheetName);
		row = sheet.getRow(rowNum);
		cell= row.getCell(cellNum);
		
		DataFormatter format = new DataFormatter();
		String cellData = format.formatCellValue(cell);
		
		file.close();
		workbook.close();
		return cellData;
		
	}
}

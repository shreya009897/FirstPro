package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting {

	public static XSSFWorkbook WB;
	public static XSSFSheet WS;
	public static XSSFRow Rw;
	public static XSSFCell CL;
	public static	FileInputStream fn;
	public static String getCellValue(String filename, String Sheetname, int row, int column) throws Exception {
		fn = new FileInputStream(filename);
		WB = new XSSFWorkbook(fn);
		WS = WB.getSheet(Sheetname);
		CL = WB.getSheet(Sheetname).getRow(row).getCell(column); // student, password
		WB.close();
		return CL.getStringCellValue();
	}
	public static int getRowCount(String filename, String Sheetname) throws Exception {
		fn = new FileInputStream(filename);
		WB = new XSSFWorkbook(fn);
		WS = WB.getSheet(Sheetname);
		int toRow = WS.getLastRowNum()+1;
		WB.close();
		return toRow;
	}
	public static int getCellCount(String filename, String Sheetname) throws Exception {
		fn = new FileInputStream(filename);
		WB = new XSSFWorkbook(fn);
		WS = WB.getSheet(Sheetname);
		int toCell = WS.getRow(0).getLastCellNum();
		WB.close();
		return toCell;
	}
	
}

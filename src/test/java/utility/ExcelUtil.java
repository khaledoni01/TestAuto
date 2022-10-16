package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	public static Object[][] getExcelData(String excelFilePath, String excelSheet) {
		
		String[][] arrayExcelData = null;
		
		FileInputStream excelFile = null;
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
	    XSSFCell cell = null;
	    
		try {
			excelFile = new FileInputStream(new File(excelFilePath));
			wb = new XSSFWorkbook(excelFile);
			sheet = wb.getSheet(excelSheet);

	    }catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
			    
		int sheetRowCount = sheet.getLastRowNum();
		int sheetCellCount = sheet.getRow(0).getLastCellNum();
		arrayExcelData = new String[sheetRowCount][sheetCellCount];
		
		for (int r=1; r <= sheetRowCount; r++) {

			for (int c=0; c < sheetCellCount; c++) {
				arrayExcelData[r-1][c] = getCellData(sheet.getRow(r).getCell(c, MissingCellPolicy.CREATE_NULL_AS_BLANK));
			}
		}		
		return arrayExcelData;
	}

	public static String getCellData(XSSFCell cell) {
		String cellData = null;
		
		try {
			switch (cell.getCellTypeEnum()) {
			case NUMERIC:
				cellData = String.valueOf(cell.getNumericCellValue()).trim();
				break;
			case STRING:
				cellData = cell.getStringCellValue().trim();
				break;
			case BLANK:
				cellData = "";
			case BOOLEAN:
				cellData = String.valueOf(cell.getBooleanCellValue()).trim();
			default:
				cellData = cell.getStringCellValue().trim();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	
	
}

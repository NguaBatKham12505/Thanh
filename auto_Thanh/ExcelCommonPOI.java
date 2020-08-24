package auto_Thanh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCommonPOI {
	private static XSSFWorkbook ExcelWbook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell ExcelWCell;
	public static XSSFSheet setExcelfile(String path, String sheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the excel data sheet
			ExcelWbook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWbook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
		return ExcelWSheet;
	}

	public static String getCellData(int RowNum, int ColNum, XSSFSheet excelWSheet) {
		try {
			ExcelWCell = excelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = ExcelWCell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static void WriteDatoToExcell(int rowcount, int colum, String filepath, String sheet, String value)
			throws FileNotFoundException {
		try {
			FileInputStream inputFile = new FileInputStream(filepath);
			XSSFWorkbook wb = new XSSFWorkbook(inputFile);
			XSSFSheet sh = wb.getSheet(sheet);
			XSSFRow row = sh.getRow(rowcount);
			FileOutputStream webdata = new FileOutputStream(filepath);
			row.createCell(colum).setCellValue(value);
			wb.write(webdata);
		} catch (Exception e) {
		}
	}
}

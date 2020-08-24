package auto_Thanh;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	private static XSSFWorkbook ExcelWbook;
	private static XSSFSheet ExcelWSheet;

	// Set file Excel
	public static void setFileExcel(String path, String sheetName) throws Exception {
		try {
			// Open file with path
			FileInputStream Excelfile = new FileInputStream(path);

			// Go to Sheet
			ExcelWbook = new XSSFWorkbook(Excelfile);
			ExcelWSheet = ExcelWbook.getSheet(sheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String[][] getTestData(String tableName) {
		String[][] testData = null;
		return null;

	}

}

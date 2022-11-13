package regression;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;

public class ExcelData {

	public Object[][] read_user_data() throws Exception, IOException {
		// I created my file here
		File myfile = new File(".\\Test_data\\user_data.xlsx");

		// Read from excel
		XSSFWorkbook wb = new XSSFWorkbook(myfile);

		// read from first sheet inside excel (" sheet1")
		XSSFSheet mysheet = wb.getSheetAt(0);

		int numbers_of_rows = mysheet.getLastRowNum() + 1;
		int numbers_of_columns = mysheet.getRow(0).getLastCellNum();

		String[][] myarr = new String[numbers_of_rows][numbers_of_columns];

		for (int i = 0; i < numbers_of_rows; i++) {

			for (int j = 0; j < numbers_of_columns; j++) {
				XSSFRow row = mysheet.getRow(i);
				myarr[i][j] = row.getCell(j).toString();

			}
		}

		return myarr;

	}

	public Object[][] read_city_data() throws Exception, IOException {
		// I created my file here
		File myfile = new File(".\\Test_data\\city_data.xlsx");

		// Read from excel
		XSSFWorkbook wb1 = new XSSFWorkbook(myfile);

		// read from first sheet inside excel (" sheet1")
		XSSFSheet mysheet = wb1.getSheetAt(0);
        
		int numbers_of_rows = mysheet.getLastRowNum() + 1;
		int numbers_of_columns = mysheet.getRow(0).getLastCellNum();

		String[][] myarr = new String[numbers_of_rows][numbers_of_columns];

		for (int i = 0; i < numbers_of_rows; i++) {

			for (int j = 0; j < numbers_of_columns; j++) {
				XSSFRow row = mysheet.getRow(i);
				myarr[i][j] = row.getCell(j).toString();

			}
		}

		System.out.println("End reading city");

		return myarr;

	}

}

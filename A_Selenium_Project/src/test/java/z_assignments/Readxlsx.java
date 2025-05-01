package z_assignments;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readxlsx {
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\DummyDataFile.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet0");
		
		int row_no=sheet.getLastRowNum();
		int cell_no=sheet.getRow(1).getLastCellNum();
		
		System.out.println(row_no);
		System.out.println(cell_no);
		
		for(int r=0; r<=row_no; r++) {
			XSSFRow current_row=sheet.getRow(r);
			for(int c=0; c<cell_no; c++) {
				String value= current_row.getCell(c).toString();
				System.out.print(value+"   ");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		System.out.println("Reading is done....!!");

	}

	
}

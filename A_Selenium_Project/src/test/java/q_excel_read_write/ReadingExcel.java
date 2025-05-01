package q_excel_read_write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File-->Workbook-->Sheets-->Rows-->Cells

public class ReadingExcel {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/TestData/DummyDataFile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet0");  //workbook.getSheetAt(0);
		
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows:"+totalrows); //6
		System.out.println("Number of cells:"+totalcells);  //4
		
		for(int r=0;r<totalrows;r++)				//row index start from 0
		{
			XSSFRow currentRow=sheet.getRow(r);
			
				for(int c=0;c<totalcells;c++)		// cell index start from 0
				{
					XSSFCell cell=currentRow.getCell(c);
					String value=cell.toString();
//					OR
//					String value=currentRow.getCell(c).toString();
					System.out.print(value+"      ");
				}				
				System.out.println();
		}
		
		workbook.close();
		file.close();
		
	}

}

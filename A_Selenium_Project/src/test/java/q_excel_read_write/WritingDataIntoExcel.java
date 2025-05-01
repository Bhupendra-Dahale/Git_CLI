package q_excel_read_write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File-->Workbook-->Sheets---->Rows--->Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\myfile.xlsx"); 

		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Hardcore Data");
		
		//Creating rows, cells and update data without loop
		XSSFRow row1=sheet.createRow(0);
				
		row1.createCell(0).setCellValue("welcome");
		row1.createCell(1).setCellValue("12345");
		row1.createCell(2).setCellValue("xyz");
				
		XSSFRow row2=sheet.createRow(1);
		
		row2.createCell(0).setCellValue("abc");
		row2.createCell(1).setCellValue("4567");
		row2.createCell(2).setCellValue("testing");
		
		
		XSSFSheet sheet2 = workbook.createSheet("UserDefine Data");
		
		//creating rows, cells and update data using loop
		Scanner sc=new Scanner(System.in);
		
		for(int r=0;r<=3;r++)
		{
			XSSFRow currentrow=sheet2.createRow(r);
						
			for(int c=0;c<2;c++)
			{
				//currentrow.createCell(c).setCellValue("welcome");
				
				System.out.println("Enter a value:");
				String value=sc.next();
				currentrow.createCell(c).setCellValue(value);
				
			}
		}
			
		workbook.write(file);
		sc.close();
		workbook.close();
		file.close();
		
		System.out.println("Writing is done!!!!");
		
	}

}

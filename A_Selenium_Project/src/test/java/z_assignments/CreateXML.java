package z_assignments;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateXML {
	public static void main(String args[]) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\DummyDataFile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet();
		
		Scanner sc=new Scanner(System.in);
		
		for(int r=0;r<=6;r++)
		{
			XSSFRow row=sheet.createRow(r);
		
			for(int c=0;c<=3;c++) 
			{
				System.out.println("Enter the values :");
				String value=sc.next();
				row.createCell(c).setCellValue(value);
			}
		}
		workbook.write(file);
		
		workbook.close();
		file.close();
		sc.close();
		
		System.out.println("Writing is Done ....!!");
	}

}

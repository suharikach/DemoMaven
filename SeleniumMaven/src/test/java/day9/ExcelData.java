package day9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

//import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelData {
	File src;
	
	@Test
	public void readData() throws IOException
	{
		src=new File("./TestData/Data.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1=wb.getSheet("sheet1");
		int row=sh1.getLastRowNum();
		
		XSSFRow r1=sh1.getRow(0);
		XSSFCell c1=r1.getCell(0);
		System.out.println(c1);
		
		FileOutputStream fout=new FileOutputStream(src);
		sh1.getRow(0).createCell(2).setCellValue("2.41.0");
	
		
		wb.write(fout);
		fout.close();
	}

}

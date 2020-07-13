package Assign5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ConvertExcelData {
	
	@Test
	public void convertexcel() throws IOException
	{
	XSSFWorkbook wb = null;
	XSSFSheet ws;
	String[] xs;
	FileOutputStream webdata;
	try 
	{
		wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/Data1.xlsx")));
		webdata=new FileOutputStream("./TestData/Data1.xlsx");
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	ws=wb.getSheet("Sheet1");
	System.out.println(ws.getLastRowNum());
	int col, row=ws.getLastRowNum();
	xs=new String[row+1];
	col=ws.getRow(0).getLastCellNum();
	//System.out.println(col);
	
	for(int i=1;i<=row;i++)
	{
	//System.out.println("entered the loop"+i);
	XSSFRow xr=ws.getRow(i);
	XSSFCell xc=xr.getCell(0); 
	if(xc.getCellType()==CellType.STRING)
	{
	xs[i]=xc.getStringCellValue();
	}
	if(xc.getCellType()==CellType.NUMERIC)
	{
	xs[i]=String.valueOf(xc.getNumericCellValue());
	}
	System.out.println(xs[i]);
	ws.getRow(i).createCell(1).setCellValue(xs[i]);
	//xs[i]=xc.getStringCellValue();
	} 

}
	//wb.write(webdata);
}   


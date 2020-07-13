package day9;

import java.io.File;
 
import java.io.FileInputStream;
 
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import org.testng.annotations.Test;
 
public class WriteExcel {
	String filepath="./TestData/Data1.xlsx";
 @Test(priority=1)
 public String readDataFromExcel( )
 {
	 System.out.println("Read data");
     String data=null;
     try
     {
         FileInputStream input= new FileInputStream(filepath);
         XSSFWorkbook wb=new XSSFWorkbook(input);
         XSSFSheet sh=wb.getSheet("Sheet1");
         XSSFRow row=sh.getRow(0);
         System.out.println(row.getCell(0).toString());
     }
     catch(Exception e)
     {
         System.out.println(e);
     }
     return data;
  }
@Test(priority=2)
public void writeDataFromExcel()
{
	System.out.println("Write data");
 try
 {
     FileInputStream input=new FileInputStream(filepath);
     XSSFWorkbook wb=new XSSFWorkbook(input);
     XSSFSheet sh=wb.getSheet("Sheet1");
     XSSFRow row=sh.getRow(0);
     FileOutputStream webdata=new FileOutputStream(filepath);
     row.createCell(1).setCellValue("value");
     wb.write(webdata);

 }
 catch(Exception e)
 {

 }
}
 }
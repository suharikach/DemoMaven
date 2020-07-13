package TestSureShot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;
public ExcelDataProvider()
{
	try
	{
		wb= new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Data.xlsx")));
	} 
	catch (IOException e)
	{
		System.out.println("Unable to Openthe Excel"+e.getMessage());
	}
	
	
}
	public String ExcelDataValue(String sheetName, int row, int col)
	{
	String value=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	return value;
	}

}

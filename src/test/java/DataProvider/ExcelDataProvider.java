package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src=new File("./ApplicationTestData/Testdata.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);	
		    } 
		catch (Exception e) 
		{
			System.out.println("The error message is:"+e.getMessage());
		}	
	}
	
	public String getdata(int Sheetnum,int Row,int Column)
	{
		String data=wb.getSheetAt(Sheetnum).getRow(Row).getCell(Column).getStringCellValue();
		return data;
	}
	
	public String getdata(String Sheetname,int Row, int Column)
	{
		String data=wb.getSheet(Sheetname).getRow(Row).getCell(Column).getStringCellValue();
		return data;	
	}
	
	}



package Factory;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;

public class DataProviderFactory 
{
  public static ConfigDataProvider Configdata()
  {
	  ConfigDataProvider configdata=new ConfigDataProvider();
	  return configdata;
  }
  
  public static ExcelDataProvider Exceldata()
  {
	  ExcelDataProvider exceldata=new ExcelDataProvider();
	  return exceldata;
  }
}

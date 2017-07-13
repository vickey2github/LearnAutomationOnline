package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider() 
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			} 
		catch (Exception e) 
		{
			System.out.println("The error message is:"+e.getMessage());
		}
	}
	
	public String getapplicationurl()
	{
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getiepath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getchromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	

}

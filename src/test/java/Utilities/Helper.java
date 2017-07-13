package Utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	
	public static String capturescreenshot(WebDriver driver,String screenshotname)
    {
	    TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String Destination= "C:\\com.learnautomation.hybrid.\\Screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
		 try 
		 {
			FileUtils.copyFile(src, new File(Destination));
		 } 
		 catch (Exception e) 
		 {
			System.out.println("Failed to capture the screenshot"+ e.getMessage());
		 }
	   
	    return Destination;
     }
}


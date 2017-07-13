package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{
 static WebDriver driver;
 
 public static WebDriver getbrowser(String browsername)
 {
	if(browsername.equalsIgnoreCase("firefox"))
	{
	 System.setProperty("webdriver.gecko.driver", DataProviderFactory.Configdata().getfirefoxpath());	
	 driver=new FirefoxDriver();	
	}
	else if(browsername.equalsIgnoreCase("chrome"))
	{
		System.setProperty("WebDriver.Chrome.driver",DataProviderFactory.Configdata().getchromepath());
		driver=new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("ie"))
	{
		System.setProperty("Webdriver.IE.driver", DataProviderFactory.Configdata().getiepath());
		driver=new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
}

 public static void closebrowser(WebDriver ldriver)
 {
	driver.quit(); 
 }
 
 
}

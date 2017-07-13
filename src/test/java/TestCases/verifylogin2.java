package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.FBpage;
import Pages.Loginpage;

public class verifylogin2 
{
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    
    @BeforeMethod
    public void openfbbrowser()
    {
    	report=new ExtentReports("./Reports/Loginpage1.html", true);
    	logger=report.startTest("Verifying FBpage", "Verifying login and logout page");
    	driver=BrowserFactory.getbrowser("firefox");
    	logger.log(LogStatus.INFO, "Firefox browser has been launched");
    	driver.get(DataProviderFactory.Configdata().getapplicationurl());
    	logger.log(LogStatus.INFO, "Application has been opened");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
  
    @Test
  	public void verifyfbpage()
  	{
  		Loginpage login=PageFactory.initElements(driver, Loginpage.class);
  		logger.log(LogStatus.INFO, "Creating PageObject for FBloginpage");
  		login.loginfb(DataProviderFactory.Exceldata().getdata(1, 0, 0), DataProviderFactory.Exceldata().getdata("Sheet2", 0, 1));
  		logger.log(LogStatus.INFO, "Entering the FBLogin Credentials successfully");
  		login.loginbutton();
  		logger.log(LogStatus.INFO, "Clicking on FBlogin button successfully");
  		login.verifylogoutpagetitle();
  		logger.log(LogStatus.PASS, "Logingin successfully and getting Logout page title");
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		FBpage fbpage=PageFactory.initElements(driver, FBpage.class);
  		logger.log(LogStatus.INFO, "Creating the PageObject for FBpage");
  		fbpage.accountsettingsbutton();
  		logger.log(LogStatus.INFO, "Entering the Account Setting Options");
  		fbpage.logoutbutton();
  		logger.log(LogStatus.INFO, "Clicking on FBLogOut button under AccountSetting Options");
  		fbpage.verifyloginpagetitle();
  		logger.log(LogStatus.PASS, "Logging Out sucessfully and getting the Login Page title successfully");
  	}
    
    @AfterMethod
    public void teardown(ITestResult result)
    {
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		String path=Utilities.Helper.capturescreenshot(driver, result.getName());
    		logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
    	}
    	BrowserFactory.closebrowser(driver);
    	report.endTest(logger);
    	report.flush();
    }
    
  
}

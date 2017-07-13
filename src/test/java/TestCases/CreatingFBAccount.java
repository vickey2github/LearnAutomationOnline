package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.Signuppage;

public class CreatingFBAccount
{
	WebDriver driver;
	
 @BeforeMethod
 public void openbrowser()
 {
	 driver=BrowserFactory.getbrowser("firefox");
	 driver.get(DataProviderFactory.Configdata().getapplicationurl());
	 
 }
 
 @Test
 public void signingFB()
 {
	 Signuppage signup=PageFactory.initElements(driver, Signuppage.class);
	 signup.signupdetails("selenium", "tester", "5512338885", "selenium@2tester");
	 Utilities.Helper.capturescreenshot(driver, "1.Giving up Fname,Lname,Mobileno and new pswd details");
	 signup.getmonthname("Dec");
	 Utilities.Helper.capturescreenshot(driver, "2.Selecting Month from dropdown");
	 signup.getdaynum(11);
	 Utilities.Helper.capturescreenshot(driver, "3.Selecting day from dropdown");
	 signup.getyear("1988");
	 Utilities.Helper.capturescreenshot(driver, "4.Selecting Year from dropdown");
	 signup.getgender("Male");
	 Utilities.Helper.capturescreenshot(driver, "5.Clicking on Male radio button");
	 signup.createaccount();
	 Utilities.Helper.capturescreenshot(driver, "6.After clicking on Createaccount button");
	 
 }
 
 @AfterMethod
 public void closebrowser()
 {
	 BrowserFactory.closebrowser(driver);
 }
}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Loginpage
{
	WebDriver driver;
	
	public Loginpage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath=".//*[@id='email']") WebElement username;
	@FindBy(xpath=".//*[@id='pass']") WebElement password;
	@FindBy(xpath=".//input[@value='Log In']") WebElement loginbutton;
	
	public void loginfb(String usname,String pswd)
	{
		username.sendKeys(usname);
		password.sendKeys(pswd);
	}
	
	public void loginbutton()
	{
		loginbutton.click();
	}
	
	 public void verifylogoutpagetitle()
	  {
		  String my_title=driver.getTitle();
		  String Expected="Facebook";
		  Assert.assertTrue(my_title.contentEquals(Expected),"Couldn't able to find Logout page title");
		  System.out.println("Logout page title found successfully");
		  
	  }

}

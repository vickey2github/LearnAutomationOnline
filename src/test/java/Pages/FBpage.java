package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FBpage 
{
  WebDriver driver;
  
  public FBpage(WebDriver ldriver)
  {
	  this.driver=ldriver;
  }
  
  @FindBy(xpath=".//*[text()='Home']") WebElement homebutton;
  @FindBy(xpath=".//*[text()='Account Settings']") WebElement accountsettingsbutton;
  @FindBy(xpath=".//*[text()='Log Out']") WebElement logoutbutton;

  public void homebutton()
  {
	  homebutton.click();
  }
  
  public void accountsettingsbutton()
  {
	  accountsettingsbutton.click();  
  }
  
  public void logoutbutton()
  {
	  logoutbutton.click();
  }
  
  public void verifyloginpagetitle()
  {
	  String my_title=driver.getTitle();
	  String Expected="Facebook - Log In or Sign Up";
	  Assert.assertTrue(my_title.contentEquals(Expected),"Couldn't able to find Login page title");
	  System.out.println("Login page title found successfully");
  }
}



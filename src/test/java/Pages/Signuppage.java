package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Signuppage 
{
	WebDriver driver;
	
	public Signuppage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
  @FindBy(xpath=".//input[@aria-label='First name']") WebElement firstname;
  @FindBy(xpath=".//input[@aria-label='Last name']") WebElement lastname;
  @FindBy(xpath=".//input[@aria-label='Mobile number or email']") WebElement mobilenumber;
  @FindBy(xpath=".//input[@aria-label='New password']") WebElement newpassword;
  @FindBy(id="month") WebElement month_dropdown;
  @FindBy(id="day") WebElement day_dropdown;
  @FindBy(id="year") WebElement year_dropdown;
  @FindBy(xpath=".//*[text()='Female']") WebElement Femaleradiobutton;
  @FindBy(xpath=".//*[text()='Male']") WebElement Maleradiobutton;
  @FindBy(xpath=".//*[text()='Create Account']") WebElement createaccount;
  
  public void signupdetails(String fname,String lname,String phnnum,String newpswd)
  {
	  firstname.sendKeys(fname);
	  lastname.sendKeys(lname);
	  mobilenumber.sendKeys(phnnum);
	  newpassword.sendKeys(newpswd);
  }
  
  public void getmonthname(String monthname)
  {
	 Select month_list=new Select(month_dropdown);
	 List <WebElement> monthnames=month_list.getOptions();
	 for(WebElement ele: monthnames )
	 {
		 String month_name= ele.getText();
		 System.out.println("Monthname is:" + month_name); 
		 if(month_name.equalsIgnoreCase(monthname))
		 {
			 month_list.selectByVisibleText(monthname);
			 System.out.println("Selected Monthname is:" + month_name); 
			 break;
		 }
		 
	 }
	  
	 
  }
  
  public void getdaynum(int daynum)
  {
	  Select day_list=new Select(day_dropdown);
	  List <WebElement> daynumbers=day_list.getOptions();
	  int total_days=daynumbers.size();
	  System.out.println("The total number of days are:" +total_days);
	  for(int i=1;i<=total_days;i++)
	  {   
		  String day_num=daynumbers.get(i).getText();
		  System.out.println("The date of the month is:"+day_num);
		  if(day_num.equalsIgnoreCase(Integer.toString(daynum)))
		  {
			  day_list.selectByIndex(daynum);
			  System.out.println("Selected date of the month is:"+day_num);
			  break;
			 
		  }
      }
	  
  }
  
  public void getyear(String year)
  {
	 Select year_list=new Select(year_dropdown);
	 List <WebElement> yearnumbers=year_list.getOptions();
	 for(WebElement ele: yearnumbers )
	 {
		 String year_num= ele.getText();
		 System.out.println("The Year is:" + year_num); 
		 if(year_num.equalsIgnoreCase(year))
		 {
			 year_list.selectByValue(year);
			 System.out.println("Selected Year is:" + year_num); 
			 break;
		 }
		 
	 }
  }
  
  public void getgender(String gendername)
  {
	  if(gendername.equalsIgnoreCase("Male"))
	  {
		  Maleradiobutton.click();
	  }
	  else if(gendername.equalsIgnoreCase("Female"))
	  {
		  Maleradiobutton.click();
	  }
  }
  
  
  public void createaccount()
  {
	  createaccount.click();
  }
}

package pages;
import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BasePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import reports.ExtentManager;

public class RegisterPage extends BasePage
{
	
	@FindBy(id=Constants.FIRST_NAME)
	WebElement FIRST_NAME;
	@FindBy(id=Constants.LAST_NAME)
	WebElement LAST_NAME;
	@FindBy(id=Constants.EMAIL)
	WebElement EMAIL;
	@FindBy(id=Constants.RETYPE_EMAIL)
	WebElement RETYPE_EMAIL;
	@FindBy(id=Constants.PASSWORD)
	WebElement PASSWORD;
	@FindBy(id=Constants.RETYPE_PASSWORD)
	WebElement RETYPE_PASSWORD;
	@FindBy(id=Constants.MOBILE_TELEPHONE_NUMBER)
	WebElement MOBILE_TELEPHONE_NUMBER;
	@FindBy(id=Constants.BIRTHDAY_DAY)
	WebElement BIRTHDAY_DAY;
	@FindBy(id=Constants.BIRTHDAY_MONTH)
	WebElement BIRTHDAY_MONTH;
	@FindBy(id=Constants.BIRTHDAY_YEAR)
	WebElement BIRTHDAY_YEAR;
	@FindBy(id=Constants.GENERAL_NEWS_LETTER_CHK)
	WebElement GENERAL_NEWS_LETTER_CHK;
	@FindBy(id=Constants.DAILY_DEALS_CHK)
	WebElement DAILY_DEALS_CHK;
	@FindBy(id=Constants.SPECIAL_OFFER_FROM_US)
	WebElement SPECIAL_OFFER_FROM_US;
	@FindBy(id=Constants.SPECIAL_OFFER_FROM_PARTNER)
	WebElement SPECIAL_OFFER_FROM_PARTNER;	
	@FindBy(name=Constants.REGISTER_BTN)
	WebElement REGISTER_BTN;
	@FindBy(linkText=Constants.HERE)
	WebElement HERE;
	

	ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	ExtentTest test ;
	 	
	public RegisterPage(WebDriver driver) throws IOException 
	{
			super(driver);
	}

	public void enterRegistrationDetails(String firstname,String lastename,String email,String retypeEmail,String password,String retypePassword,String telephonenumber) throws InterruptedException 
	{   
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(FIRST_NAME));
		FIRST_NAME.sendKeys(firstname);
		LAST_NAME.sendKeys(lastename);
		EMAIL.sendKeys(email);
		RETYPE_EMAIL.sendKeys(retypeEmail);
		PASSWORD.sendKeys(password);
		RETYPE_PASSWORD.sendKeys(retypePassword);
		MOBILE_TELEPHONE_NUMBER.sendKeys(telephonenumber);
		selectDate("11","DEC","2003");
		scrollTo(GENERAL_NEWS_LETTER_CHK);
		uncheckAllNewsAndSpecialOffer(GENERAL_NEWS_LETTER_CHK);
		uncheckAllNewsAndSpecialOffer(DAILY_DEALS_CHK);
		uncheckAllNewsAndSpecialOffer(SPECIAL_OFFER_FROM_US);
		uncheckAllNewsAndSpecialOffer(SPECIAL_OFFER_FROM_PARTNER);
		clickOnRegisterButton(REGISTER_BTN) ;
		clickonPopupLink() ;
	}
	public void clickOnRegisterButton(WebElement Element) 
	{
		Element.sendKeys(Keys.ENTER);
	}
	
	
	public void uncheckAllNewsAndSpecialOffer(WebElement element )   
	{  
		 if ( element.isSelected() ) 
		   {
			 element.click();
		   }
	}
	public void selectDate(String day,String month,String year )   
	{  
		BIRTHDAY_DAY.sendKeys(day);
		BIRTHDAY_MONTH.sendKeys(month);
		BIRTHDAY_YEAR.sendKeys(year);
	}
	public void scrollTo(WebElement Element) 
	{
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", Element);
	}

	public void clickonPopupLink() 
	{

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(HERE));
		
		HERE.click();
	}
	

	@AfterMethod
	public void quit()
	{
			reports.flush(); //generate the reports
	}
 }

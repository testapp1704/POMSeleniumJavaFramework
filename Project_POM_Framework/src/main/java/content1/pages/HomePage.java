package content1.pages;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import content1.base.BasePage;
import reports.ExtentManager;

public class HomePage extends BasePage
{
	
	@FindBy(xpath=Constants.CONTENTONE_MENU)
	WebElement CONTENTONE_MENU;
	
	@FindBy(xpath=Constants.IV_MENU)
	WebElement IV_MENU;
	
	@FindBy(xpath=Constants.CONTENTONE_SEASON_MENU)
	WebElement CONTENTONE_SEASON_MENU;
	
	@FindBy(xpath=Constants.CONTENTONE_SUMMER2021_MENU)
	WebElement CONTENTONE_SUMMER2021_MENU;
	
	@FindBy(xpath=Constants.TRIPS_MENU)
	WebElement TRIPS_MENU;
	
	@FindBy(xpath=Constants.REGION_EUROPE)
	WebElement REGION_EUROPE;
	
	@FindBy(xpath=Constants.ALERT_SECTION)
	WebElement ALERT_SECTION;
	
	@FindBy(xpath=Constants.DU_BUTTON_MENU)
	WebElement DU_BUTTON_MENU;
	
	@FindBy(xpath=Constants.LOGOUT_BUTTON)
	WebElement LOGOUT_BUTTON;

	ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	ExtentTest test ;
	 	
	public HomePage(WebDriver driver) throws IOException 
	{
			super(driver);
	}

	public void gotoTrip() throws InterruptedException 
	{   
	    CONTENTONE_MENU.click();
	    IV_MENU.click();
	    CONTENTONE_SEASON_MENU.click();
	    CONTENTONE_SUMMER2021_MENU.click();
	    TRIPS_MENU.click();
	}

	public void selectRegion() throws InterruptedException 
	{
		    waitForElementToBeClickable(REGION_EUROPE);
			REGION_EUROPE.click();
	}

	public void Logout() throws IOException, InterruptedException 
	{
		   DU_BUTTON_MENU.click();
		   LOGOUT_BUTTON.click();
	}
	@AfterMethod
	public void quit()
	{
			reports.flush(); //generate the reports
	}
 }

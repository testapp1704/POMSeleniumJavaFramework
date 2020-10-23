package content1.pages;
import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import content1.base.BasePage;
import reports.ExtentManager;

public class TripPage extends BasePage{
	
	@FindBy(xpath=Constants.CREATE_TRIP_BUTTON)
	WebElement CREATE_TRIP_BUTTON;
	
	@FindBy(xpath=Constants.STAY_BUTTON)
	List<WebElement> STAY_BUTTON;
	
	@FindBy(xpath=Constants.DISCARD_BUTTON)
	WebElement DISCARD_BUTTON;
	
	@FindBy(xpath=Constants.ENTER_TRIP_NAME)
	WebElement ENTER_TRIP_NAME;
	
	@FindBy(xpath=Constants.REGION_EUROPE)
	WebElement REGION_EUROPE;
	
	@FindBy(xpath=Constants.SEARCH_TEXT)
	WebElement SEARCH_TEXT;
	
	@FindBy(xpath=Constants.SELECT_TRIP)
	WebElement SELECT_TRIP;
	
	@FindBy(xpath=Constants.SAVE_PUBLISH_BUTTON)
	WebElement SAVE_PUBLISH_BUTTON; 
	
	@FindBy(xpath=Constants.ALERT_MESSAGE)
	WebElement ALERT_MESSAGE;
	
	
	public TripPage(WebDriver driver) throws IOException 
	{
		super(driver);
	}
	   ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
	   ExtentTest test ;
	   String tripName ;
	
   public void generateTripName(String AutomationTest)  
   {
		  Random objGenerator = new Random();
		  for (int iCount = 0; iCount< 1; iCount++)
		  { 
		   int randomNumber = objGenerator.nextInt(90);
		   String tripName = AutomationTest + randomNumber ;
		   this.tripName = tripName ;
		  }
	  }

   public void clickOnCreateTrip() throws InterruptedException  
	{
		CREATE_TRIP_BUTTON.click(); 
		if (isElementPresent(STAY_BUTTON)== true)
		DISCARD_BUTTON.click();
	}

   public void enterTripName() 
	{
	   System.out.println(tripName);
	   ENTER_TRIP_NAME.sendKeys(tripName);
	}
	
   public void clickOnSavePublish() 
	{
	  SAVE_PUBLISH_BUTTON.click();
	}

   public void goToTripSearchScreen()  
	{
	  driver.navigate().back();
	}

   public void searchTrip() throws InterruptedException  
	{
	   SEARCH_TEXT.sendKeys(tripName);
	   waitForElementToBeClickable(SELECT_TRIP);
	   SELECT_TRIP.click();
	   if (isElementPresent(STAY_BUTTON)== true)
	   DISCARD_BUTTON.click();
	}
   
   public void searchExistingTrip(String tripName) throws InterruptedException  
		{
		   SEARCH_TEXT.sendKeys(tripName);
		   Thread.sleep(1000);
		   SELECT_TRIP.click();
		   if (isElementPresent(STAY_BUTTON)== true)
		   DISCARD_BUTTON.click();
		}
   @AfterMethod
		public void quit()
		{
	   reports.flush(); //generate the reports
		}
}

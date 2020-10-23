package content1.pages;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import content1.base.BasePage;
import reports.ExtentManager;

public class LoginPage extends BasePage
{
   @FindBy(name=Constants.USERNAME)
   WebElement USERNAME;
   @FindBy(name=Constants.PASSWORD)
   WebElement PASSWORD;
   @FindBy(xpath=Constants.LOGIN_BUTTON)
   WebElement LOGIN_BUTTON;

   ExtentReports rep = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
   ExtentTest test ;
   String expectedTitle ;
   WebDriver driver;
	
	public LoginPage(WebDriver driver) throws IOException 
	{
		super(driver);
	}

	public void doLogin(String userid,String password)  
	{
			USERNAME.sendKeys(userid);
			PASSWORD.click();
			PASSWORD.sendKeys(password);
			LOGIN_BUTTON.click();								
	}

	@AfterMethod
	public void quit()
	{
		driver.close();
		rep.flush(); //generate the reports
	}
}

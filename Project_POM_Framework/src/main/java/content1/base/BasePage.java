package content1.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import content1.pages.Constants;
import listener.WebEventListener;
import reports.ExtentManager;
import util.Xls_Reader;


public class BasePage 
{
public static WebDriver driver;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
ExtentReports reports = ExtentManager.getReport(System.getProperty("user.dir")+"//reports//");
ExtentTest test ;
public Properties prop;
public String testName=null;
public util.Xls_Reader xls = new util.Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");

	public BasePage() 
	{}
	
	public BasePage(WebDriver driver) throws IOException 
	{
			PageFactory.initElements(driver, this);
	}
	/*****************************Initialise the prop file********************************/
	public void init()
	{
		if(prop==null){
			prop=new Properties();
			try 
			{
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//projectconfig.properties");
				prop.load(fs);
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void openBrowser(String bType)
	{		
		if(bType.equals("Mozilla")) 
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("Moziladriver"));
			driver=new FirefoxDriver();
		}
		else if(bType.equals("Chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
		 //	System.setProperty("webdriver.chrome.driver", prop.getProperty("Chromedriver"));
			driver=new ChromeDriver();
		}
		else if (bType.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("IEdriver"));
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("QA_Env"));
	}	
	/*****************************Common Functionality ********************************/	
	public void clickOnSaveAndPublish(WebElement element) throws InterruptedException
	{
		element.click();
  		Thread.sleep(3000);	
    }
	public void scrollDownThePage() throws AWTException, InterruptedException  
	{
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		   Thread.sleep(1000);
	}
	 public void scrollUpThePage() throws AWTException, InterruptedException  
	{
			   Robot robot = new Robot();
			   robot.keyPress(KeyEvent.VK_PAGE_UP);
			   robot.keyRelease(KeyEvent.VK_PAGE_UP);
			   Thread.sleep(1000);   
	}
	/*****************************Wait logic ********************************/	
	
	public void waitForElementToBeClickable(WebElement element) throws InterruptedException
	{
  			Thread.sleep(2000);	
    }
	/*****************************Validation********************************/	
	public boolean validateTitle(String expectedTitle) 
	{
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		return false;
	}
	
	public boolean isdisplayed(String locatorKey)
	{
		if(locatorKey == null)
		{
		  return false;	
		} else
			return true;
	}
	
	public boolean isElementPresent(List<WebElement> locatorKey)
	{
		List<WebElement> elementList=null;
		elementList = locatorKey;
		if(elementList.size()==0)
			return false;	
		else
			return true;
	}
	/*****************************Reporting********************************/	
		public void reportPass(String msg)
	{
		test.log(Status.PASS, msg);
	}
	
	public void reportFailure(String msg)
	{
		test.log(Status.FAIL, msg);
		takeScreenShot();
		Assert.fail(msg);
	}
	
	public void takeScreenShot()
	{
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*****************************Reporting********************************/
	@AfterMethod
	public void quit()
	{
		if(reports!=null)
		  reports.flush();
	}
}


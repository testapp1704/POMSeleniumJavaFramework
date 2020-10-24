package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;


public class Constants {
	
	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";

	public static final String DEFAULT_USERNAME="demouser@ttc.com";
	public static final String DEFAULT_PASWD="4dG]Xb-lfY";

	public static final String USERNAME ="username";
	public static final By USERNAME_LOCATOR=By.name(USERNAME);
	
	public static final String PASSWORD = "password";
	public static final By PASSWORD_LOCATOR=By.name(PASSWORD);
	
	public static final String LOGIN_BUTTON = "//localize[contains(text(),'Login')]";
	public static final By LOGIN_BUTTON_LOCATOR=By.className(LOGIN_BUTTON);
	
	public static final String LOGOUT_BUTTON = "//localize[contains(text(),'Logout')]";
	public static final By LOGOUT_BUTTON_LOCATOR=By.xpath(LOGOUT_BUTTON);
	
	public static final String HOMEPAGE_TITLE = "//h1[@class='title']";
	public static final By HOMEPAGE_TITLE_LOCATOR=By.xpath(HOMEPAGE_TITLE);
	
	public static final String CONTENTONE_MENU = "//body[@id='umbracoMainPageBody']/div/div[@id='mainwrapper']/div[@id='leftcolumn']/div[@id='navigation']/div/div[@id='tree']/ul/li/ul/li[1]/div[1]/ins[1]";
	public static final By CONTENTONE_MENU_LOCATOR=By.xpath(CONTENTONE_MENU);
	
	public static final String IV_MENU = "//body[@id='umbracoMainPageBody']/div/div[@id='mainwrapper']/div[@id='leftcolumn']/div[@id='navigation']/div/div[@id='tree']/ul/li/ul/li/ul/li[1]/div[1]/ins[1]";
	public static final By IV_MENU_LOCATOR=By.xpath(IV_MENU);
	
	public static final String CONTENTONE_SEASON_MENU = "//body[@id='umbracoMainPageBody']/div/div[@id='mainwrapper']/div[@id='leftcolumn']/div[@id='navigation']/div/div[@id='tree']/ul/li/ul/li/ul/li/ul/li[1]/div[1]/ins[1]";
	public static final By CONTENTONE_SEASON_MENU_LOCATOR=By.xpath(CONTENTONE_SEASON_MENU);
	
	public static final String CONTENTONE_SUMMER2021_MENU = "/html/body/div/div/div[1]/div[2]/div[1]/div[2]/ul/li/ul/li[1]/ul/li[1]/ul/li[1]/ul/li[1]/div/ins";
	public static final By CONTENTONE_SUMMER2021_MENU_LOCATOR=By.xpath(CONTENTONE_SUMMER2021_MENU);
	
	public static final String TRIPS_MENU = "//a[@class='umb-tree-item__label'][contains(text(),'Trips')]";
	public static final By TRIPS_MENU_LOCATOR=By.xpath(TRIPS_MENU);
	
	public static final String DU_BUTTON_MENU = "//span[@class='ng-scope ng-binding']";
	public static final By DU_BUTTON_MENU_LOCATOR=By.xpath(DU_BUTTON_MENU);
	
	public static final String REGION_EUROPE = "//a[contains(text(),'Europe')]";
	public static final By REGION_EUROPE_LOCATOR=By.xpath(REGION_EUROPE);
	
	public static final String ALERT_SECTION = "//li[@class='alert alert-block alert-form umb-notifications__notification animated -half-second fadeIn -no-border -extra-padding']";
	public static final By ALERT_SECTION_LOCATOR=By.xpath(ALERT_SECTION);
	
	public static final String CREATE_TRIP_BUTTON = "//a[@class='btn ng-binding']";
	public static final By CREATE_TRIP_BUTTON_LOCATOR=By.xpath(CREATE_TRIP_BUTTON);
	
	public static final String DISCARD_BUTTON = "//localize[contains(text(),'Discard changes')]";
	public static final By DISCARD_BUTTON_LOCATOR=By.xpath(DISCARD_BUTTON);
	
	public static final String ENTER_TRIP_NAME = "//input[@placeholder='Enter a name...']";
	public static final By ENTER_TRIP_NAME_LOCATOR=By.xpath(ENTER_TRIP_NAME);
	
	public static final String SEARCH_TEXT = "//div[@class='inner-addon left-addon']//input[@placeholder='Type to search...']";
	public static final By SEARCH_TEXT_LOCATOR=By.xpath(SEARCH_TEXT);
	
	public static final String STAY_BUTTON = "//localize[contains(text(),'Stay')]";
	public static final By STAY_BUTTON_LOCATOR=By.xpath(STAY_BUTTON);
	
	public static final String ALERT_MESSAGE = "//li[@class='alert alert-block alert-form umb-notifications__notification animated -half-second fadeIn -no-border -extra-padding']//div[@class='ng-scope']//div//div[@class='ng-scope']";
	public static final By ALERT_MESSAGE_LOCATOR=By.xpath(ALERT_MESSAGE);
	
	public static final String SELECT_TRIP = "//a[@class='umb-table-body__link ng-binding']";
	public static final By SELECT_TRIP_LOCATOR=By.xpath(SELECT_TRIP);
	
	public static final String SAVE_PUBLISH_BUTTON = "//localize[contains(text(),'Save and publish')]";
	public static final By SAVE_PUBLISH_BUTTON_LOCATOR=By.xpath(SAVE_PUBLISH_BUTTON);
	
	
			
		//------------------------------------------------------------------------------------------
	// titles
		
		//div[@class='umb-toggle__handler shadow-depth-1']
		//input[@id='dayNumber']
		public static final String HOME_PAGE_TITLE = "Umbraco - content1.qa.travcorpservices.com";
    // report path
		public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
		public static final How CSS_SEL = How.CSS;
	// sheet names
		public static final String TEST_STATUS_SHEET = "Test Status";
	//col names
		public static final Object COL_SUBJECT = "Subject";
		public static final Object COL_DATE = "Date";
		public static final String TCID = "TCID";
		public static final String RUNMODE = "Runmode";
}

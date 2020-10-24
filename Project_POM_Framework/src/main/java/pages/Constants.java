package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.How;


public class Constants {
	
	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";

	public static final String FIRST_NAME = "firstname";
	public static final By FIRST_NAME_LOCATOR=By.xpath(FIRST_NAME);
	
	public static final String LAST_NAME = "surname";
	public static final By LAST_NAME_LOCATOR=By.id(LAST_NAME);
	
	public static final String EMAIL = "email";
	public static final By EMAIL_LOCATOR=By.id(EMAIL);
	
	public static final String RETYPE_EMAIL = "email2";
	public static final By RETYPE_EMAIL_LOCATOR=By.id(RETYPE_EMAIL);
	
	public static final String PASSWORD = "password";
	public static final By PASSWORD_LOCATOR=By.id(PASSWORD);
	
	public static final String RETYPE_PASSWORD = "password2";
	public static final By RETYPE_PASSWORD_LOCATOR=By.id(RETYPE_PASSWORD);
	
	public static final String MOBILE_TELEPHONE_NUMBER = "telno1";
	public static final By MOBILE_TELEPHONE_NUMBER_LOCATOR=By.id(MOBILE_TELEPHONE_NUMBER);
	
	public static final String BIRTHDAY_DAY = "day";
	public static final By BIRTHDAY_DAY_LOCATOR=By.id(BIRTHDAY_DAY);
	
	public static final String BIRTHDAY_MONTH = "month";
	public static final By BIRTHDAY_MONTH_LOCATOR=By.id(BIRTHDAY_MONTH);
	
	public static final String BIRTHDAY_YEAR = "year";
	public static final By BIRTHDAY_YEAR_LOCATOR=By.id(BIRTHDAY_YEAR);
	
	public static final String GENERAL_NEWS_LETTER_CHK = "newsletter_general";
	public static final By GENERAL_NEWS_LETTER_CHK_LOCATOR=By.id(GENERAL_NEWS_LETTER_CHK);
	
	public static final String DAILY_DEALS_CHK = "newsletter_daily-deals";
	public static final By DAILY_DEALS_CHK_LOCATOR=By.id(DAILY_DEALS_CHK);
	
	public static final String SPECIAL_OFFER_FROM_US = "smsPromotions";
	public static final By SPECIAL_OFFER_FROM_US_LOCATOR=By.id(SPECIAL_OFFER_FROM_US);
	
	public static final String SPECIAL_OFFER_FROM_PARTNER = "partnerPromotions";
	public static final By SPECIAL_OFFER_FROM_PARTNER_LOCATOR=By.id(SPECIAL_OFFER_FROM_PARTNER);
	
	public static final String REGISTER_BTN = "registerButton";
	public static final By REGISTER_BTN_LOCATOR=By.name(REGISTER_BTN);
	
	public static final String HOMEPAGE_TITLE = "//div[@id='welcome']";
	public static final By HOMEPAGE_TITLE_LOCATOR=By.xpath(HOMEPAGE_TITLE);
	
	public static final String HERE = "here";
	public static final By HERE_LOCATOR=By.linkText(HERE);
	
	public static final String SEARCH_FIELD = "//input[@class='search-field ']";
	public static final By SEARCH_FIELD_LOCATOR=By.xpath(SEARCH_FIELD);
	
	public static final String SEARCH_BTN = "//button[@type='submit']";
	public static final By SEARCH_BTN_LOCATOR=By.xpath(SEARCH_BTN);
	
	
	
}

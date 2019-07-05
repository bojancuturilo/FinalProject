package page.objects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public static final String PAGE_URL = "http://localhost/izlet/index.php";
	private static final String FIRSTNAME = "//input[@name='firstname']";
	private static final String LASTNAME = "//input[@name='lastname']";
	private static final String REGUSERNAME = "//div[@class='register_form']//input[@name='username']";
	private static final String EMAIL = "//input[@name='email']";
	private static final String REGPASSWORD = "//div[@class='register_form']//input[@name='password']";
	private static final String SUBMITBUTTON = "//input[@id='blue_btn']";

	// Methods for First Name
	public static WebElement getFirstName(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(FIRSTNAME));
		return driver;
	}

	public static void clickFirstName(WebDriver wd) {
		getFirstName(wd).click();
	}

	public static void sendKeysFirstName(WebDriver wd, String s) {
		getFirstName(wd).sendKeys(s);
	}

	// Methods for Last Name
	public static WebElement getLastName(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LASTNAME));
		return driver;
	}

	public static void clickLastName(WebDriver wd) {
		getLastName(wd).click();
	}

	public static void sendKeysLastName(WebDriver wd, String s) {
		getLastName(wd).sendKeys(s);
	}

	// Methods for Username
	public static WebElement getUsername(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(REGUSERNAME));
		return driver;
	}

	public static void clickUsername(WebDriver wd) {
		getUsername(wd).click();
	}

	public static void sendKeysUsername(WebDriver wd, String s) {
		getUsername(wd).sendKeys(s);
	}

	// Methods for Email
	public static WebElement getEmail(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(EMAIL));
		return driver;
	}

	public static void clickEmail(WebDriver wd) {
		getEmail(wd).click();
	}

	public static void sendKeysEmail(WebDriver wd, String s) {
		getEmail(wd).sendKeys(s);
	}

	// Methods for Password
	public static WebElement getPassword(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(REGPASSWORD));
		return driver;
	}

	public static void clickPassword(WebDriver wd) {
		getPassword(wd).click();
	}

	public static void sendKeysPassword(WebDriver wd, String s) {
		getPassword(wd).sendKeys(s);
	}

	// Methods for Registration Button
	public static WebElement getRegisterButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(SUBMITBUTTON));
		return driver;
	}

	public static void clickRegisterButton(WebDriver wd) {
		getRegisterButton(wd).click();
	}

}
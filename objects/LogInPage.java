package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public static final String LOGIN_URL = "http://localhost/izlet/dashboard.php";

	private static final String USER = "//input[@placeholder='username']";
	private static final String PASS = "//input[@placeholder='password']";
	private static final String LOG_IN = "//input[@name='login']";
	private static final String LOG_OUT = "//a[@id='logoutBtn']";

	// Method to open LogIn page
	public static void openLogInPage(WebDriver wd) {
		wd.get(LOGIN_URL);
	}

	// Method to navigate LogIn page
	public static void navigateToLogInPage(WebDriver wd) {
		wd.navigate().to(LOGIN_URL);
	}

	// Method to find LogIn Username
	public static WebElement getUser(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(USER));
		return driver;
	}

	// Method to click on LogIn Username
	public static void clickUser(WebDriver wd) {
		getUser(wd).click();
	}

	// Method to set LogIn Username
	public static void sendKeysUser(WebDriver wd, String s) {
		getUser(wd).sendKeys(s);
	}

	// Method to find LogIn Password
	public static WebElement getPass(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(PASS));
		return driver;
	}

	// Method to click on LogIn Password
	public static void clickPass(WebDriver wd) {
		getPass(wd).click();
	}

	// Method to set LogIn Password
	public static void sendKeysPass(WebDriver wd, String s) {
		getPass(wd).sendKeys(s);
	}

	// Method to find LogIn Button
	public static WebElement getLogInButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LOG_IN));
		return driver;
	}

	// Method to click on LogIn Button
	public static void clickLogInButton(WebDriver wd) {
		getLogInButton(wd).click();
	}

	// Method to find LogOut Button
	public static WebElement getLogOutButton(WebDriver wd) {
		WebElement driver = wd.findElement(By.xpath(LOG_OUT));
		return driver;
	}

	// Method to click on LogOut Button
	public static void clickLogOutButton(WebDriver wd) {
		getLogOutButton(wd).click();
	}

}
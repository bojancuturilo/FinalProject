package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.Constant;
import utility.ExcelUtils;

public class LogInTest {

	// Method to open LogIn page
	public static void openHomePage(WebDriver wd) {
		if (!wd.getCurrentUrl().equals(LogInPage.LOGIN_URL)) {
			wd.navigate().to(LogInPage.LOGIN_URL);
		}
	}

	// Method for LogIn from user
	public static void userLogIn(WebDriver wd, Scanner sc) throws Exception {

		System.out.println("Please Log In:");

		// User
		System.out.println("Username");
		LogInPage.clickUser(wd);
		LogInPage.sendKeysUser(wd, sc.nextLine());

		// Pass
		System.out.println("Password");
		LogInPage.clickPass(wd);
		LogInPage.sendKeysPass(wd, sc.nextLine());

		// Submit
		LogInPage.clickLogInButton(wd);
		if (wd.getCurrentUrl().equals(LogInPage.LOGIN_URL)) {
			System.out.println("Log in successful.");
		} else
			System.out.println("Log in unsuccessful.");
	}

	// Method to fill LogIn from Excel file
	public static void LogInFill(WebDriver driver, int i) throws Exception {
		String data;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_1);
		// UserName
		LogInPage.clickUser(driver);
		data = ExcelUtils.getCellData(i, 2);
		LogInPage.sendKeysUser(driver, data);
		// Password
		LogInPage.clickPass(driver);
		data = ExcelUtils.getCellData(i, 4);
		LogInPage.sendKeysPass(driver, data);
		// LoginButton
		LogInPage.clickLogInButton(driver);
	}

	// Method for LogIn All Users from Excel file
	public static void AutomaticTestAll(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_1);
		for (int i = 1; i <= ExcelUtils.getWorkSheet().getLastRowNum(); i++) {
			LogInFill(driver, i);
			LogInPage.clickLogOutButton(driver);

			// Input results in Excel file
			ExcelUtils.setCellData("LogInStatus", 0, 7);
			// results
			if (driver.getCurrentUrl().equals(RegistrationPage.PAGE_URL)) {
				System.out.println("Login successful.");
				ExcelUtils.setCellData("Pass", i, 7);
			} else {
				System.out.println("Login unsuccessful.");
				ExcelUtils.setCellData("Fail", i, 7);
			}

		}
	}
	
	// Method for LogIn All Users from Excel file
		public static void LogInTestOne(WebDriver driver) throws Exception {
			ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_1);
			for (int i = 1; i < 2; i++) {
				LogInFill(driver, i);

			}
		}

}
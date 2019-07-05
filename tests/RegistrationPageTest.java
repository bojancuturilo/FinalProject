package page.tests;

import java.util.Scanner;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import utility.*;
import org.openqa.selenium.WebDriver;

public class RegistrationPageTest {

	/// Method Registration Form from user
	public static void userRegistration(WebDriver wd, Scanner sc) throws Exception {
		System.out.println("Please Register:");

		// Input First Name
		System.out.println("Enter Your First Name");
		RegistrationPage.clickFirstName(wd);
		RegistrationPage.sendKeysFirstName(wd, sc.nextLine());

		// Last name
		System.out.println("Enter Your Last Name");
		RegistrationPage.clickLastName(wd);
		RegistrationPage.sendKeysLastName(wd, sc.nextLine());

		// Username
		System.out.println("Enter Your Username");
		RegistrationPage.clickUsername(wd);
		RegistrationPage.sendKeysUsername(wd, sc.nextLine());

		// Email
		System.out.println("Enter Your Email");
		RegistrationPage.clickEmail(wd);
		RegistrationPage.sendKeysEmail(wd, sc.nextLine());

		// Password
		System.out.println("Enter Your Password");
		RegistrationPage.clickPassword(wd);
		RegistrationPage.sendKeysPassword(wd, sc.nextLine());

		// Submit
		RegistrationPage.clickRegisterButton(wd);
	}

	public static void testUserRegistration(WebDriver wd, Scanner sc) throws Exception {
		userRegistration(wd, sc);

		if (wd.getCurrentUrl().equals(RegistrationPage.PAGE_URL)) {
			System.out.println("Registration successful.");
		} else
			System.out.println("Registration unsuccessful.");

	}

	// Method for Registration from Excel file
	public static void fillRegForm(WebDriver wd, int i) throws Exception {

		String data;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_1);

		// First name
		RegistrationPage.clickFirstName(wd);
		data = ExcelUtils.getCellData(i, 0);
		RegistrationPage.sendKeysFirstName(wd, data);

		// LastName
		RegistrationPage.clickLastName(wd);
		data = ExcelUtils.getCellData(i, 1);
		RegistrationPage.sendKeysLastName(wd, data);

		// Username
		RegistrationPage.clickUsername(wd);
		data = ExcelUtils.getCellData(i, 2);
		RegistrationPage.sendKeysUsername(wd, data);

		// Email
		RegistrationPage.clickEmail(wd);
		data = ExcelUtils.getCellData(i, 3);
		RegistrationPage.sendKeysEmail(wd, data);

		// Password
		RegistrationPage.clickPassword(wd);
		data = ExcelUtils.getCellData(i, 4);
		RegistrationPage.sendKeysPassword(wd, data);

		// Submit
		RegistrationPage.clickRegisterButton(wd);

	}

	// Method to Register All Users from Excel file
	public static void AutomaticTestAll(WebDriver wd) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_1);
		for (int i = 1; i <= ExcelUtils.getWorkSheet().getLastRowNum(); i++) {
			fillRegForm(wd, i);
			
			// Input results in Excel file
			ExcelUtils.setCellData("RegStatus", 0, 6);
			// results
			if (wd.getCurrentUrl().equals(RegistrationPage.PAGE_URL)) {
				System.out.println("Registration successful.");
				ExcelUtils.setCellData("Pass", i, 6);
			} else {
				System.out.println("Registration unsuccessful.");
				ExcelUtils.setCellData("Fail", i, 6);
			}

		}
	}

}
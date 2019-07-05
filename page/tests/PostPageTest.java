package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.PostPage;
import utility.Constant;
import utility.ExcelUtils;

public class PostPageTest {

	// Method to post from user
	public static void userNewPost(WebDriver wd, Scanner sc) throws Exception {

		// New Post Button
		PostPage.clickNewPost(wd);

		// Title
		System.out.println("Post Title:");
		PostPage.clickPostTitle(wd);
		PostPage.sendKeysPostTitle(wd, sc.nextLine());

		// Location
		System.out.println("Location");
		PostPage.clickLocation(wd);
		PostPage.sendKeysLocation(wd, sc.nextLine());

		// Image

		PostPage.sendKeysImage(wd);

		// Transport
		System.out.println("Choose transport by typing one:");
		System.out.println("Walk, Car, Motorbike, Bicycle or Bus");
		PostPage.selectTransport(wd, sc.nextLine());

		// Description
		System.out.println("Post Description");
		PostPage.clickDescription(wd);
		PostPage.sendKeysDescription(wd, sc.nextLine());

		// Submit
		PostPage.clickPostButton(wd);
	}

	// Method to post using data from Excel file
	public static void AutomaticFill(WebDriver driver, int i) throws Exception {
		// Make a Post
		PostPage.clickNewPost(driver);
		// Pull Excel data
		String data;
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_2);
		// Name
		PostPage.clickPostTitle(driver);
		data = ExcelUtils.getCellData(i, 1);
		PostPage.sendKeysPostTitle(driver, data);
		// Location
		PostPage.clickLocation(driver);
		data = ExcelUtils.getCellData(i, 2);
		PostPage.sendKeysLocation(driver, data);
		
		// Description
		PostPage.clickDescription(driver);
		data = ExcelUtils.getCellData(i, 0);
		PostPage.sendKeysDescription(driver, data);
		// PostButton
		PostPage.clickPostButton(driver);
	}

	public static void AutomaticPostAll(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Constant.PATH + Constant.FILE_NAME, Constant.SHEET_NAME_2);
		for (int i = 1; i <= 5; i++) {
			AutomaticFill(driver, i);

		}

		if (driver.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Posts are successfully set.");
		} else
			System.out.println("Posts are not set.");
	}

}
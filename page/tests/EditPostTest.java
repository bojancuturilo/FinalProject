package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.EditPost;
import page.objects.PostPage;

public class EditPostTest {
	
	private static Scanner sc;

	// Method for Edit Last Post
	public static void editPost(WebDriver driver) throws Exception {
		sc = new Scanner(System.in);
		// Expand
		EditPost.clickExpand(driver);
		
		// Edit
		EditPost.clickEdit(driver);
		
		// Name
		EditPost.clickName(driver);
		System.out.println("Enter new Title Name: ");
		String strName = sc.nextLine();
		EditPost.sendKeysName(driver, strName);
		
		// Location
		EditPost.clickLocation(driver);
		System.out.println("Enter new Location: ");
		String strLocation = sc.nextLine();
		EditPost.sendKeysLocation(driver, strLocation);
		
		// Transport
		EditPost.clickDropDown(driver);
		System.out.println("Choose Walk, Car, Motorbike, Bus or Bicycle: ");
		String strDropDown = sc.nextLine();
		EditPost.selectDropDown(driver, strDropDown);
		
		// Description
		EditPost.clickDescription(driver);
		System.out.println("Enter new Description: ");
		String strDescription = sc.nextLine();
		EditPost.sendDescription(driver, strDescription);
		
		// ClickPost
		EditPost.clickPost(driver);

		if (driver.getCurrentUrl().equals(PostPage.POST_URL)) {
			System.out.println("Post edit successful.");
		} else
			System.out.println("Post edit unsuccessful.");
	}

}
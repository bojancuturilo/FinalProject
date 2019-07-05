package page.tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import page.objects.DeletePosts;
import page.objects.PostPage;
import utility.Constant;
import utility.ExcelUtils;

public class DeletePostsTest {

	// Method for Delete 2 last Posts
	public static void AutomaticPostDelete(WebDriver driver) throws Exception {

		for (int i = 0; i < 2; i++) {
			DeletePosts.clickExpand(driver);
			DeletePosts.clickDelete(driver);
			
			if (driver.getCurrentUrl().equals(PostPage.POST_URL)) {
				System.out.println("Post are deleted.");
			} else
				System.out.println("Post are not deleted.");
		}

	}
}
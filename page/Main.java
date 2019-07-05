package page;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.objects.LogInPage;
import page.objects.RegistrationPage;
import page.tests.DeletePostsTest;
import page.tests.EditPostTest;
import page.tests.LogInTest;
import page.tests.PostPageTest;
import page.tests.RegistrationPageTest;

public class Main {

	public static final String URL = "http://localhost/izlet/index.php";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		LogInTest.openHomePage(wd);

		try {

			System.out.println("If you want Manual Testing Choose 1");
			System.out.println("If you want Automatic Testing Choose 2");
			System.out.println("If you want Delete 2 Last posts Choose 3");
			System.out.println("If you want Edit Last post Choose 4");

			int n = sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1:
				RegistrationPageTest.testUserRegistration(wd, sc);
				LogInTest.userLogIn(wd, sc);
				PostPageTest.userNewPost(wd, sc);
				break;
			case 2:
				RegistrationPageTest.AutomaticTestAll(wd);
				LogInTest.AutomaticTestAll(wd);
				LogInTest.LogInTestOne(wd);
				PostPageTest.AutomaticPostAll(wd);
				break;
			case 3:
				LogInTest.LogInTestOne(wd);
				DeletePostsTest.AutomaticPostDelete(wd);
				break;
			case 4:
				LogInTest.LogInTestOne(wd);
				EditPostTest.editPost(wd);
				break;
			default:
				System.out.println("You entered the wrong number");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			wd.quit();
		}

	}

}
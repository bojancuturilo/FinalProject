package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DeletePosts {

	private static final String expand = "fa-ellipsis-v";
	private static final String delete = "fa-trash-alt";
	
	// Expand buttons
	public static WebElement getExpand(WebDriver driver) {
		WebElement wb = driver.findElement(By.className(expand));
		return wb;
	}

	public static void clickExpand(WebDriver driver) {
		getExpand(driver).click();
	}
	
	// Delete
	public static WebElement getDelete(WebDriver driver) {
		WebElement wb = driver.findElement(By.className(delete));
		return wb;
	}

	public static void clickDelete(WebDriver driver) {
		getDelete(driver).click();
	}
	
}
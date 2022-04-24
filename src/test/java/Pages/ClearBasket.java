package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClearBasket {

	WebDriver driver = null;

	By itemListToBeDeleted = By.xpath("//input[@value='Delete']");

	public ClearBasket(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> deleteItems() {
		List<WebElement> itemsInBasket = driver.findElements(itemListToBeDeleted);
		return itemsInBasket;
	}

}

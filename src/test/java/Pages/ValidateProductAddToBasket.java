package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateProductAddToBasket {
	
	WebDriver driver = null;
	
	By basket = By.id("nav-cart-text-container");
	By basketProduct = By.xpath("//div[@class=\"sc-list-item-content\"]//span[@class=\"a-truncate-cut\"]");
	
	public ValidateProductAddToBasket(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openTheBasket() {
		driver.findElement(basket).click();
	}
	
	public String productInTheBasket() {
		String productBasket = driver.findElement(basketProduct).getText();
		return productBasket;
		
		
	}

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct {
	
	WebDriver driver = null;
	
	By searchTextbox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");
	
	By validateResults = By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small']//span)[1]");
	
	public SearchProduct(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProductInTextBox(String product) {
		driver.findElement(searchTextbox).sendKeys(product);
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public String validateSearchResults() {
		String search_result = driver.findElement(validateResults).getText();
		return search_result;
	}
	
}

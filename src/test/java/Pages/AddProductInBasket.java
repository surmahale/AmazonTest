package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductInBasket {
	
	WebDriver driver = null;
	
	
	By productToSelect = By.linkText("HP EliteBook 840 G2 14-inch Ultrabook Laptop PC (Intel Core i5-5200U, 8GB RAM, 256GB SSD, WiFi, WebCam, Windows 10 Professional 64-bit)(Renewed)");
	By addToCart = By.id("add-to-cart-button");
	
	By sideSheetPane = By.id("attach-desktop-sideSheet");
	By noAcceptance = By.id("attach-popover-lgtbox");
	
	public AddProductInBasket(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement searchProduct(String productToBeSelected) {
		WebElement productToSelected = driver.findElement(productToSelect);
		productToSelected.sendKeys(productToBeSelected);
		return productToSelected;
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
	
	public boolean sideSheetEnable() {
		boolean sideSheet = driver.findElement(sideSheetPane).isEnabled();
		return sideSheet;
	}
	
	public void doNotAccept() {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(noAcceptance)).click();
	}
}

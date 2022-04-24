package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidateSubTotalInBasket {
	public static int invalidItemQty = -1;
	public static int invalidSubtotalQty = -2;

	WebDriver driver = null;

	By quantityDropdown = By.id("a-autoid-1-announce");
	By quantitySelection = By.xpath("(//li[@class=\"a-dropdown-item quantity-option\"]//a[@id=\"quantity_2\"])");
	By subtotalInBasket = By.xpath("(//div[@data-name='Subtotals']//span[@id='sc-subtotal-label-buybox'])");
	By itemQuantityOnDropdown = By.xpath("//span[@class='a-dropdown-prompt']");

	public ValidateSubTotalInBasket(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnQuantityDropdown() {

		driver.findElement(quantityDropdown).click();
	}

	public void increaseTheQuantityOfProduct() {
		driver.findElement(quantitySelection).click();
	}

	public int getSubTotalQty() {
		String subtotalQty = driver.findElement(subtotalInBasket).getText();
		return Integer.parseInt(subtotalQty.split(" ")[1].substring(1));
	}

	public int getItemQty() {
		String itemQtyOnDropdown = driver.findElement(itemQuantityOnDropdown).getText();
		return Integer.parseInt(itemQtyOnDropdown);
	}
}

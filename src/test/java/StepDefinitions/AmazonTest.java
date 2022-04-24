package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AddProductInBasket;
import Pages.CookiePage;
import Pages.LoginPage;
import Pages.SearchProduct;
import Pages.ValidateProductAddToBasket;
import Pages.ValidateSubTotalInBasket;
import io.cucumber.java.en.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class AmazonTest {

	WebDriver driver = null;
	String productSelected;

	@Given("user launches browser")
	public void user_launches_browser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\BrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the Amazon UK website
		driver.get("https://www.amazon.co.uk");

		CookiePage CookiePage = new CookiePage(driver);

		// Save cookie preferences
		CookiePage.customiseCookieButton();
		CookiePage.savePreferencesButton();

//		driver.findElement(By.id("sp-cc-customize")).click();
//		driver.findElement(By.className("a-button-input")).click();
		Thread.sleep(3000);
	}

	@When("user logins to Amazon")
	public void user_logins_to_amazon() throws InterruptedException {

		LoginPage LoginPage = new LoginPage(driver);

		// Enter user credentials and click on login button
		LoginPage.clickSignInButton();
		LoginPage.enterUsername("emeaintegrationautomation@outlook.com");
		LoginPage.clickContinueButton();
		LoginPage.enterPassword("AutomationTestUK.");
		LoginPage.clickSubmitButton();

//		driver.findElement(By.xpath("//div[@id=\"nav-tools\"]/a[2]")).click();
//		driver.findElement(By.id("ap_email")).sendKeys("emeaintegrationautomation@outlook.com");
//		driver.findElement(By.id("continue")).click();
//		driver.findElement(By.id("ap_password")).sendKeys("AutomationTestUK.");
//		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);

	}

	@When("searches for the product and verifies the search result")
	public void searches_for_the_product_and_verifies_the_search_result() {

		SearchProduct SearchProduct = new SearchProduct(driver);

		// Search for the product
		SearchProduct.searchProductInTextBox("HP Laptop");
		SearchProduct.clickSearchButton();

//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("HP Laptop");
//		driver.findElement(By.id("nav-search-submit-button")).click();

		// Validate search results
		String searchResults = SearchProduct.validateSearchResults();
		if (searchResults != "No Results") {
			System.out.println("There are results for the search");
		} else {
			System.out.println("No results for the search");
		}

	}

	@Then("add the product to basket")
	public void add_the_product_to_basket() throws InterruptedException {

		AddProductInBasket AddProductInBasket = new AddProductInBasket(driver);

		System.out.println("add_the_product_to_basket() : waiting for 30 seconds");
		Thread.sleep(30000);
		System.out.println("add_the_product_to_basket() : done waiting for 30 seconds");
		// Add the product to basket
		WebElement productToSelect = AddProductInBasket.searchProduct(
				"HP EliteBook 840 G2 14-inch Ultrabook Laptop PC (Intel Core i5-5200U, 8GB RAM, 256GB SSD, WiFi, WebCam, Windows 10 Professional 64-bit)(Renewed)");
		productSelected = productToSelect.getText();
		productToSelect.click();
		AddProductInBasket.addToCart();

		AddProductInBasket.doNotAccept();

//		WebElement product = driver.findElement(By.linkText("HP 14s-fq0015na 14\" Full HD Laptop AMD Athlon 3020E 4GB RAM 128GB SSD Windows 10 Home S Mode, White"));
//		productSelected = product.getText();
//		product.click();
//		driver.findElement(By.id("add-to-cart-button")).click();

//		if ( driver.findElement(By.id("attach-desktop-sideSheet")).isEnabled())	{
//			
//				//driver.findElement(By.id("attach-popover-lgtbox")).click();
//			driver.findElement(By.xpath("(//span[@id=\"attachSiNoCoverage\"]//input)[1]")).click();
//		}
//		Thread.sleep(5000);
	}

	@Then("validate the product is added to basket")
	public void validate_the_product_is_added_to_basket() throws InterruptedException, AWTException {

		ValidateProductAddToBasket ValidateProductAddToBasket = new ValidateProductAddToBasket(driver);

		// Action action = new Action(driver);
		Thread.sleep(10000);
		// Open the basket
		try {
			ValidateProductAddToBasket.openTheBasket();
		} catch (ElementClickInterceptedException e) {
			pressEscape();
			ValidateProductAddToBasket.openTheBasket();
		}

		// driver.findElement(By.xpath("(//span[@class='a-button-inner']//a)[1]")).click();

		// Comparing the actual and expected subtotal to ensure item is added in basket
		String basketProductName = ValidateProductAddToBasket.productInTheBasket();
		if (productSelected.equals(basketProductName)) {
			System.out.println("They both match and product is added to Basket");
		} else
			System.out.println("They do not match");

//		String basketProductName = driver.findElement(By.xpath("//div[@class=\"sc-list-item-content\"]//span[@class=\"a-truncate-cut\"]")).getText();
//		if(productSelected.equals(basketProductName)) {
//			System.out.println("They both match");
//		}
//		else
//			System.out.println("They do not match");		
	}

	@And("increase the quantity and validate the subtotal")
	public void increase_the_quantity_and_validate_the_subtotal() throws InterruptedException {

		ValidateSubTotalInBasket ValidateSubTotalInBasket = new ValidateSubTotalInBasket(driver);

		// Increase the quantity
		ValidateSubTotalInBasket.clickOnQuantityDropdown();
		ValidateSubTotalInBasket.increaseTheQuantityOfProduct();
		Thread.sleep(10000);
//		driver.findElement(By.id("a-autoid-1-announce")).click();
//		driver.findElement(By.xpath("(//li[@class=\"a-dropdown-item quantity-option\"]//a[@id=\"quantity_2\"])"))
//				.click();

		// Validate the quantity is increased
		int itemQty = ValidateSubTotalInBasket.getItemQty();
		int subTotalQty = ValidateSubTotalInBasket.getSubTotalQty();
		
		Assert.assertEquals(subTotalQty, itemQty);
		
		driver.close();
		
		System.out.println("Amazon Test completed. Thank you");

		// String quantity =
		// driver.findElement(By.className("a-dropdown-prompt")).getText();
		// String subTotal =
		// driver.findElement(By.xpath("//span[@id=\"sc-subtotal-label-activecart\"]")).getText();

	}

	public void pressEscape() throws AWTException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();;
//		action.keyDown(Keys.ESCAPE);
//		action.keyUp(Keys.ESCAPE);

		System.out.println("Pressed ESC button");

	}

}
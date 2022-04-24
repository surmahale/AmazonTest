package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookiePage {

	WebDriver driver = null;

	By customizeCookieButton = By.id("sp-cc-customize");
	By savePreferencesButton = By.className("a-button-input");

	public CookiePage(WebDriver driver) {
		this.driver = driver;
	}

	public void customiseCookieButton() {
		driver.findElement(customizeCookieButton).click();
	}

	public void savePreferencesButton() {
		driver.findElement(savePreferencesButton).click();
	}

}

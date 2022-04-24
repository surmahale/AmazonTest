package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver = null;
	
	By signInButton = By.xpath("//div[@id=\"nav-tools\"]/a[2]");
	By emailTextbox = By.id("ap_email");
	By continueButton = By.id("continue");
	By passwordTextbox = By.id("ap_password");
	By submitButton = By.id("signInSubmit");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public void enterUsername(String username) {
		driver.findElement(emailTextbox).sendKeys(username);
	}
	
	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextbox).sendKeys(password);
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}	
	
}

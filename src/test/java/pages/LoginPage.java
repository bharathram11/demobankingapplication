package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	
	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators using @FindBy
	@FindBy(xpath = "//input[@name='uid']") 
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']") 
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='btnLogin']") 
	private WebElement loginBtn;
	
	// Actions with Explicit Wait
	public void setUsername(String name) {
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(name);
	}
	
	public void setPassword(String passwd) {
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(passwd);
	}
	
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}
}

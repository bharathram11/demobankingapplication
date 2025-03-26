package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
  
    public HomePage(WebDriver driver) {
       super(driver);
    }
    
    // Locators using @FindBy
    @FindBy(xpath = "//a[normalize-space()='New Customer']") 
    private WebElement newCustomer;
    
    
    @FindBy(xpath = "//a[normalize-space()='Demo Site']") 
    private WebElement logo;
    
    @FindBy(xpath = "//div[contains(@class, 'logo')]/a/img") 
    private WebElement homevimg;
    
    
    // Methods to click on different links
    public void clickNewCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(newCustomer)).click();
    }

    // Method to verify if the logo is displayed
    public boolean isLogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(logo)).isDisplayed();
    }
    public boolean isVImgDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(homevimg)).isDisplayed();
    }
}

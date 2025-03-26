package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddNewCustomerPage extends BasePage {
	
    // Constructor
    public AddNewCustomerPage(WebDriver driver) {
       super(driver);
    }
    
    // Locators using @FindBy
    @FindBy(xpath = "//input[@name='name']") 
    private WebElement customerName;
    
    @FindBy(xpath = "(//input[@name='rad1'])[1]") 
    private WebElement maleRadioBtn;
    
    @FindBy(xpath = "//*[@id='dob']") 
    private WebElement datePicker;
    
    @FindBy(xpath = "//textarea[@name='addr']") 
    private WebElement address;
    
    @FindBy(xpath = "//input[@name='city']") 
    private WebElement city;
    
    @FindBy(xpath = "//input[@name='state']") 
    private WebElement state;
    
    @FindBy(xpath = "//input[@name='pinno']") 
    private WebElement pin;
    
    @FindBy(xpath = "//input[@name='telephoneno']") 
    private WebElement telephoneNo;
    
    @FindBy(xpath = "//input[@name='emailid']") 
    private WebElement emailId;
    
    @FindBy(xpath = "//input[@name='sub']") 
    private WebElement submitBtn;
    
    @FindBy(xpath = "//p[normalize-space()='Add New Customer']") 
    private WebElement addNewCustomerHeader;
    
    @FindBy(xpath="//label[@id='message']")
    private WebElement errorMsgforCN;
    @FindBy(xpath="//label[@id='message3']")
    private WebElement errorMsgforAddress;
    @FindBy(xpath="//label[@id='message4']")
    private WebElement errorMsgforCity;
    @FindBy(xpath="//label[@id='message5']")
    private WebElement errorMsgforState;
    @FindBy(xpath="//label[@id='message6']")
    private WebElement errorMsgforPin;
    @FindBy(xpath="//label[@id='message7']")
    private WebElement errorMsgforTelephone;
    @FindBy(xpath="//label[@id='message9']")
    private WebElement errorMsgforEmail;
    @FindBy(xpath="//a[contains(text(), 'Home')]")
    private WebElement Homebtn;
    
    // Methods to interact with elements
    public void enterCustomerName(String name) {
        wait.until(ExpectedConditions.visibilityOf(customerName)).click();
        wait.until(ExpectedConditions.visibilityOf(customerName)).sendKeys(name);
    }
    
    public void selectMaleGender() {
    
    	// Small wait for stability
    	wait.until(ExpectedConditions.elementToBeClickable(maleRadioBtn)).click();

    }
    
    public void enterDateOfBirth(String dob) {
        wait.until(ExpectedConditions.visibilityOf(datePicker)).sendKeys(dob);
    }
    
    public void enterAddress(String addr) {
        wait.until(ExpectedConditions.visibilityOf(address)).sendKeys(addr);
    }
    
    public void enterCity(String cityName) {
        wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(cityName);
    }
    
    public void enterState(String stateName) {
        wait.until(ExpectedConditions.visibilityOf(state)).sendKeys(stateName);
    }
    
    public void enterPin(String pinCode) {
        wait.until(ExpectedConditions.visibilityOf(pin)).sendKeys(pinCode);
    }
    
    public void enterTelephoneNo(String phone) {
        wait.until(ExpectedConditions.visibilityOf(telephoneNo)).sendKeys(phone);
    }
    
    public void enterEmailId(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys(email);
    }
    
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
    
    // Method to verify if the "Add New Customer" page is displayed
    public boolean isAddNewCustomerPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(addNewCustomerHeader)).isDisplayed();
    }
    public void clcikhomebtn() {
    	wait.until(ExpectedConditions.elementToBeClickable(Homebtn)).click();
    }

    public String getErrorMessageofCn() {
      
    	try {
    		return (errorMsgforCN.getText());
    	} catch (Exception e) {
    		return (e.getMessage());
        }
    }
    public String getErrorMessageofAddress() {
        
    	try {
    		return (errorMsgforAddress.getText());
    	} catch (Exception e) {
    		return (e.getMessage());
        }
    }
	public String getErrorMessageofCity() {
	        
	    	try {
	    		return (errorMsgforCity.getText());
	    	} catch (Exception e) {
	    		return (e.getMessage());
	        }
	    }
	public String getErrorMessageofState() {
        
    	try {
    		return (errorMsgforState.getText());
    	} catch (Exception e) {
    		return (e.getMessage());
        }
    }
public String getErrorMessageofPin() {
        
    	try {
    		return (errorMsgforPin.getText());
    	} catch (Exception e) {
    		return (e.getMessage());
        }
    }
public String getErrorMessageofTelephone() {
    
	try {
		return (errorMsgforTelephone.getText());
	} catch (Exception e) {
		return (e.getMessage());
    }
}
public String getErrorMessageofEmail() {
    
	try {
		return (errorMsgforEmail.getText());
	} catch (Exception e) {
		return (e.getMessage());
    }
}
}


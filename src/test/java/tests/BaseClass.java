package tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import pages.LoginPage;
import pages.AddNewCustomerPage;
import pages.HomePage;

public class BaseClass {

    public  WebDriver driver;
    public Properties p;
    public LoginPage lp;
    public HomePage hp;
    public AddNewCustomerPage acp;
    public Logger log;

    public BaseClass() {
        log = LogManager.getLogger(this.getClass());
    }

    @BeforeClass
    public void setup() throws Exception {
        log.info("Initializing test setup...");

        // Load properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);
        log.info("Configuration file loaded successfully.");

        // Initialize WebDriver
            driver=new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            log.info("WebDriver initialized successfully.");
        

        // Launch application
        driver.get(p.getProperty("appURL2"));
        log.info("Application launched: " + p.getProperty("appURL2"));

        // Perform Login
        lp = new LoginPage(driver);
        lp.setUsername(p.getProperty("USERID"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();
        log.info("Entered credentials and attempted login.");

        // Validate successful login
        hp = new HomePage(driver);
        if (!hp.isLogoDisplayed()) {
            log.error("Login failed: Home page logo not found.");
            throw new Exception("Login failed. Home page logo not displayed.");
        }
        log.info("Login successful. Navigated to Home Page.");

        // Navigate to Add New Customer Page
        hp.clickNewCustomer();
        acp = new AddNewCustomerPage(driver);
        if (!acp.isAddNewCustomerPageDisplayed()) {
            log.error("Navigation failed: 'Add New Customer' page not displayed.");
            throw new Exception("Add New Customer page is not displayed.");
        }
        log.info("Successfully navigated to 'Add New Customer' page.");
    }

    
    @AfterClass
    public void tearDownClass() {
        if (driver != null) {
            driver.quit();
            log.info("Test execution completed. Browser closed.");
            driver = null; // Avoid accessing a closed driver
        }
    }

    
    public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
    public String randomeString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomeNumber() {
        return RandomStringUtils.randomNumeric(6);
    }

    public String todayDate() {
        SimpleDateFormat st = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        return st.format(dt);
    }

    public String randomeMobileNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomSpecialChar() {
        String alphanumeric = RandomStringUtils.randomAlphanumeric(6);
        String specialChars = "!@#$%^&*()_+{}[]<>?";
        char specialChar = specialChars.charAt(new Random().nextInt(specialChars.length()));
        return specialChar + alphanumeric;
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}

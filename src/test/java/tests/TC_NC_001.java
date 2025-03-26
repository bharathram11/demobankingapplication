package tests;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_001 extends BaseClass {
    @Test
    public void newCustomerAdding() {
        log.info("Navigating to Add New Customer page");

        // Fill customer form
        String customerName = randomeString();
        acp.enterCustomerName(customerName);
        log.info("Entered Customer Name: " + customerName);

        acp.selectMaleGender();
        log.info("Selected Gender: Male");

        String dob = todayDate();
        acp.enterDateOfBirth(dob);
        log.info("Entered Date of Birth: " + dob);

        String address = randomeString();
        acp.enterAddress(address);
        log.info("Entered Address: " + address);

        String city = randomeString();
        acp.enterCity(city);
        log.info("Entered City: " + city);

        String state = randomeString();
        acp.enterState(state);
        log.info("Entered State: " + state);

        String pin = randomeNumber();
        acp.enterPin(pin);
        log.info("Entered PIN: " + pin);

        String mobileNumber = randomeMobileNumber();
        acp.enterTelephoneNo(mobileNumber);
        log.info("Entered Mobile Number: " + mobileNumber);

        String email = randomeString() + "@gmail.com";
        acp.enterEmailId(email);
        log.info("Entered Email ID: " + email);

        acp.clickSubmit();
        log.info("Clicked on Submit button");

        // Verify success alert
        verifySuccessAlert();
    }

    // Reusable alert verification method
    private void verifySuccessAlert() {
        try {
            String alertText = driver.switchTo().alert().getText();
            log.info("Alert Text: " + alertText);

            // Adjust expected message based on actual alert text
            if (alertText.toLowerCase().contains("customer added")) {
                log.info("Success alert verified: Customer added successfully.");
            } else {
                log.warn("Alert appeared but does not match expected message.");
            }

            Assert.assertTrue(alertText.toLowerCase().contains("customer added"),
                    "Expected success message not found in alert.");
            driver.switchTo().alert().accept();
            log.info("Accepted success alert.");
        } catch (NoAlertPresentException e) {
            log.error("No success alert appeared. Possible form submission failure.", e);
            Assert.fail("No success alert appeared. Possible form submission failure.");
        }
    }
}

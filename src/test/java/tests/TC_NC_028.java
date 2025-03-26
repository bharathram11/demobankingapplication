package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_028 extends BaseClass {

    @Test(enabled=false)
    public void newCustomerAdding() {

        try {
            log.info("Clicking on Home button...");
            acp.clcikhomebtn();

            log.info("Verifying if Home Page logo is displayed...");
            boolean isLogoVisible = hp.isLogoDisplayed();
            
            // Assertion to verify if the logo is displayed
            Assert.assertTrue(isLogoVisible, "Home page logo is not displayed");
            log.info("Home page logo verification passed.");

        } catch (Exception e) {
            log.error("Exception occurred while checking the Home page logo: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

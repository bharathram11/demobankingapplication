package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_022 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        log.info("Entering empty Telephone Number...");
        acp.enterTelephoneNo(""); // Enter empty value
        
        acp.enterCity(randomeString()); // Move to another field to trigger validation
        
        try {
            String errorMsg = acp.getErrorMessageofTelephone();
            log.info("Captured Error Message: '" + errorMsg + "'");

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "Mobile no must not be blank", "Confirmation message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

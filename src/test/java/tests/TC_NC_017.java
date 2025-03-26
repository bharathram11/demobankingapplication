package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_017 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        log.info("Entering alphabetic characters in the PIN field to validate error handling.");
        acp.enterPin(randomeString()); // Entering a string instead of numbers

        try {
            String errorMsg = acp.getErrorMessageofPin();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "Characters are not allowed", "Confirmation message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

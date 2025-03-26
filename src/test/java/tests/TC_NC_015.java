package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_015 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        log.info("Entering special characters into the State field");
        acp.enterState(randomSpecialChar());  // Entering special characters to trigger validation

        try {
            String errorMsg = acp.getErrorMessageofState();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "Special characters are not allowed", "Confirmation message mismatch");
            log.info("Error message verified successfully");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_021 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        String invalidPin = " " + generateRandomNumber(5); // Add space before a 5-digit PIN
        log.info("Entering invalid PIN with leading space: '" + invalidPin + "'");
        
        acp.enterPin(invalidPin); // Entering PIN with leading space
        
        try {
            String errorMsg = acp.getErrorMessageofPin();
            log.info("Captured Error Message: '" + errorMsg + "'");

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "First character can not have space", "Confirmation message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

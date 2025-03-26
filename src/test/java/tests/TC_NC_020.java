package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_020 extends BaseClass {
    
    @Test
    public void newCustomerAdding() {
        
        String invalidPin = generateRandomNumber(5); // Generate a 5-digit PIN
        log.info("Entering invalid PIN (5 digits) into the PIN field: " + invalidPin);
        
        acp.enterPin(invalidPin); // Entering 5-digit PIN
        
        try {
            String errorMsg = acp.getErrorMessageofPin();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "PIN Code must have 6 Digits", "Confirmation message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_018 extends BaseClass {
    
    @Test
    public void newCustomerAdding() {
        
        log.info("Entering an empty value into the PIN field to validate error handling.");
        acp.enterPin(""); // Leaving PIN field empty
        
        acp.enterCity(randomeString()); // Moving to another field to trigger validation

        try {
            String errorMsg = acp.getErrorMessageofPin();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "PIN Code must not be blank", "Confirmation message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

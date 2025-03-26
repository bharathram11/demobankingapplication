package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_014 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        log.info("Entering an empty value into the State field");
        acp.enterState("");  // Leaving state field empty
        
        acp.enterAddress(randomeString());  // Moving to another field to trigger validation
        log.info("Moved to another field to trigger validation");

        try {
            String errorMsg = acp.getErrorMessageofState();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "State must not be blank", "Confirmation message mismatch");
            log.info("Error message verified successfully");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

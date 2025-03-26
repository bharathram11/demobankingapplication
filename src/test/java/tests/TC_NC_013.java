package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_013 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        acp.enterState(randomeNumber());  // Entering a numeric value in the state field
        
        try {
            String errorMsg = acp.getErrorMessageofState();
            log.info("Captured Error Message: " + errorMsg);  // Using log for better debugging
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Numbers are not allowed", "Confirmation message mismatch");
            log.info("Error message verified successfully");  // Moved outside assertion
            
        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_016 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        
        log.info("Entering a state name with a leading space to validate error handling");
        acp.enterState(" " + randomeString()); // Entering a state name starting with a space

        try {
            String errorMsg = acp.getErrorMessageofState();
            log.info("Captured Error Message: " + errorMsg);
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "First character can not have space", "Confirmation message mismatch");
            log.info("Error message verified successfully");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

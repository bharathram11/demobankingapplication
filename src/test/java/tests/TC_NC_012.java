package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_012 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        // Enter city with a leading space
        acp.enterCity(" " + randomeString());

        try {
            String errorMsg = acp.getErrorMessageofCity();
            log.info("Captured Error Message: " + errorMsg);  // Using 'log' from BaseClass

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "First character can not have space", "Confirmation message mismatch");
            log.info("Error message verified successfully.");
        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_008 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message when Address contains special characters");

        // Enter Address with special characters
        acp.enterAddress(randomSpecialChar());
        log.info("Entered Address with special characters");

        try {
            String errorMsg = acp.getErrorMessageofAddress();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Special characters are not allowed", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing validation message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

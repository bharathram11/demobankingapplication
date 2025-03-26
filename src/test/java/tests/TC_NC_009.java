package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_009 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message when City contains special characters");

        // Enter City with special characters
        acp.enterCity(randomSpecialChar());
        log.info("Entered City with special characters");

        try {
            String errorMsg = acp.getErrorMessageofCity();
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

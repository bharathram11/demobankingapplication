package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_003 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message for special characters in Customer Name");

        // Enter customer name with special characters
        String invalidName = randomSpecialChar();
        acp.enterCustomerName(invalidName);
        log.info("Entered invalid customer name: '{}'", invalidName);

        try {
            String errorMsg = acp.getErrorMessageofCn();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Special characters are not allowed", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Error while capturing the message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

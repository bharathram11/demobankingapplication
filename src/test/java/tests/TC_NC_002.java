package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_002 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message for leading space in Customer Name");

        // Enter customer name with a leading space
        String invalidName = " " + randomeString();
        acp.enterCustomerName(invalidName);
        log.info("Entered invalid customer name: '{}'", invalidName);

        try {
            String errorMsg = acp.getErrorMessageofCn();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "First character can not have space", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Error while capturing the message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

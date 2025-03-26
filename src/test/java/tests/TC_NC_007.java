package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_007 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message when Address field starts with a space");

        // Enter Address with leading space
        acp.enterAddress(" " + randomeString());
        log.info("Entered Address with a leading space");

        try {
            String errorMsg = acp.getErrorMessageofAddress();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "First character can not have space", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing validation message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

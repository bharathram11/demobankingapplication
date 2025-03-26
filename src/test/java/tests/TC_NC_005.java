package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_005 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message for customer name starting with a space");

        // Entering a name with a leading space
        acp.enterCustomerName(" " + randomeString());
        log.info("Entered customer name with a leading space");

        try {
            String errorMsg = acp.getErrorMessageofCn();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "First character can not have space", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Error while capturing validation message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

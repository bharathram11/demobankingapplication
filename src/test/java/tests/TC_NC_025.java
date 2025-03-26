package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_025 extends BaseClass {

    @Test
    public void newCustomerAdding() {

        log.info("Entering mobile number with a leading space...");
        acp.enterTelephoneNo(" " + randomeMobileNumber()); // Entering invalid input

        try {
            String errorMsg = acp.getErrorMessageofTelephone();
            log.info("Captured Error Message: '" + errorMsg + "'");

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "First character can not have space", "Error message mismatch");
            log.info("Error message verification passed successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

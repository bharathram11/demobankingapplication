package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_024 extends BaseClass {

    @Test
    public void newCustomerAdding() {

        log.info("Entering alphabetic characters into Telephone Number field...");
        acp.enterTelephoneNo(randomeString()); // Entering invalid input

        try {
            String errorMsg = acp.getErrorMessageofTelephone();
            log.info("Captured Error Message: '" + errorMsg + "'");

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "Characters are not allowed", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

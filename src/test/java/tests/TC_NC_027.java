package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_NC_027 extends BaseClass {

    @Test
    public void newCustomerAdding() {

        log.info("Entering an empty Email ID...");
        acp.enterEmailId(""); // Empty email input
        acp.enterAddress(randomeString());;

        try {
            String errorMsg = acp.getErrorMessageofEmail();
            log.info("Captured Error Message: '" + errorMsg + "'");

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg.trim(), "Email-ID must not be blank", "Error message mismatch");
            log.info("Error message verification passed successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            SoftAssert softAssert = new SoftAssert();
            softAssert.fail("Test failed due to exception: " + e.getMessage());
            softAssert.assertAll(); // Ensure the test doesn't stop execution

        }
    }
}

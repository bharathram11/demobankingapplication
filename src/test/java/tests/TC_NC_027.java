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
            log.debug("Starting error message validation process...");

            String actualErrorMsg = acp.getErrorMessageofEmail();
            log.debug("Captured Error Message: '" + actualErrorMsg + "'");

            String expectedErrorMsg = "Eml-ID must not be blank";

            if (!actualErrorMsg.trim().equals(expectedErrorMsg)) {
                log.error(" ERROR MESSAGE MISMATCH ");
                log.error("  Expected: '" + expectedErrorMsg + "'");
                log.error("  Actual:   '" + actualErrorMsg.trim() + "'");

                Assert.fail(" Test failed: Expected error message '" + expectedErrorMsg + 
                            "' but got '" + actualErrorMsg.trim() + "'");
            }

            log.info(" Error message verification PASSED successfully.");

        } catch (Exception e) {
            log.error(" ERROR: Exception occurred while capturing the error message: " + e.getMessage(), e);
            Assert.fail(" Test failed due to exception: " + e.getMessage());
        }



    }
}

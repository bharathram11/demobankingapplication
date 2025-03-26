package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_006 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message when Address field is left blank");

        // Leave Address field empty
        acp.enterAddress("");
        log.info("Address field left empty");

        // Move to another field (Selecting gender to trigger validation)
        acp.selectMaleGender();
        log.info("Moved to the next field (Gender selected) to trigger validation");

        try {
            String errorMsg = acp.getErrorMessageofAddress();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Address Field must not be blank", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing validation message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

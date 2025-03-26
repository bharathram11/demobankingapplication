package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_004 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message for blank Customer Name");

        // Enter empty customer name
        acp.enterCustomerName("");
        log.info("Entered empty Customer Name to trigger validation error");

        // Moving to another field to trigger validation
        acp.selectMaleGender();  // Not mandatory, just a way to shift focus
        log.info("Selected Male Gender to move focus and trigger validation");

        try {
            String errorMsg = acp.getErrorMessageofCn();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Customer name must not be blank", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Error while capturing the message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

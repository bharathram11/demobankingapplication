package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_010 extends BaseClass {

    @Test
    public void newCustomerAdding() {
        log.info("Validating error message for empty City field");

        // Enter empty City
        acp.enterCity("");
        log.info("Entered an empty value in City field");

     // Move to another field (Selecting gender to trigger validation)
        acp.selectMaleGender();
        log.info("Moved to the next field (Gender selected) to trigger validation");
        try {
            String errorMsg = acp.getErrorMessageofCity();
            log.info("Captured error message: '{}'", errorMsg);

            // Assertion to verify expected error message
            Assert.assertEquals(errorMsg, "City Field must not be blank", "Error message mismatch");
            log.info("Error message verified successfully.");

        } catch (Exception e) {
            log.error("Exception occurred while capturing validation message: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

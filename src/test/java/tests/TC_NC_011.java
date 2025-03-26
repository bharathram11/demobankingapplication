package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_NC_011 extends BaseClass {
    
    @Test
    public void newCustomerAdding() {
        
        acp.enterCity(randomeNumber());
       
        try {
            String errorMsg = acp.getErrorMessageofCity();
            log.info("Captured Error Message: " + errorMsg);  // Using 'log' from BaseClass
            
            // Assertion to verify the expected error message
            Assert.assertEquals(errorMsg, "Numbers are not allowed", "Confirmation message mismatch");
            log.info("Error message verified successfully.");
        } catch (Exception e) {
            log.error("Exception occurred while capturing the error message: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}

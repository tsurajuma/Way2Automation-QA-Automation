package com.umasuraj.way2automation.testcase;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.excelReader;
import com.umasuraj.way2automation.utility.CommonDataProvider;
import com.umasuraj.way2automation.utility.TestUtility;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.Test;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class AddCustomerTest extends TestBase {

    @Test(dataProviderClass = CommonDataProvider.class, dataProvider = "commonDataProvider")
    public void addCustomerTest(Hashtable<String, String> data) throws InterruptedException {

        if (!(TestUtility.isTestRunnable("OpenAccountTest", excelReader))) {

            logger.debug("SKIPPED TEST: Add Customer Test !!!");

            throw new SkipException("SKIPPED TEST: " + "AddCustomerTest" + " as the Run mode is set to NO");

        } else if (!data.get("runMode").equalsIgnoreCase("YES")) {

            logger.debug("SKIPPED DATA SET: for Add Customer Test !!!");

            throw new SkipException("SKIPPED DATA SET: for " + "AddCustomerTest" + " as the RUN mode for DATA SET is set to NO");
        }

        logger.debug("INSIDE: Add Customer Test !!!");

        click("add_customer_btn_css");
        type("first_name_txt_css", data.get("firstName"));
        type("last_name_txt_xpath", data.get("lastName"));
        type("post_code_txt_css", data.get("postCode"));
        click("add_customer_submit_btn_css");

        Thread.sleep(2000);

        acceptAlert(data.get("alertText"));

//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//
//        Assert.assertTrue(alert.getText().contains(alertText));
//        alert.accept();
        logger.debug("EXECUTED: Add Customer Test !!!");

        Thread.sleep(2000);

    } // end addCustomer() method

}// end class{}

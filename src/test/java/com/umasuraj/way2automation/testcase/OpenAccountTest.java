package com.umasuraj.way2automation.testcase;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.umasuraj.way2automation.base.TestBase;
import com.umasuraj.way2automation.utility.CommonDataProvider;
import com.umasuraj.way2automation.utility.TestUtility;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class OpenAccountTest extends TestBase {

    @Test(dataProviderClass = CommonDataProvider.class, dataProvider = "commonDataProvider")
    public void openAccountTest(Hashtable<String, String> data) throws InterruptedException {

            if (!(TestUtility.isTestRunnable("OpenAccountTest", excelReader))) {
                
            logger.debug("SKIPPED: Open Account Test !!!");
                
            throw new SkipException("SKIPPED: " + "OpenAccountTest" + " as the Run mode is set to NO");
        } else if (!data.get("runMode").equalsIgnoreCase("YES")) {
            
            logger.debug("SKIPPED DATA SET: for Open Account Test !!!");

            throw new SkipException("SKIPPED DATA SET: for " + "OpenAccountTest" + " as the RUN mode for DATA SET is set to NO");
        }

        logger.debug("INSIDE: Open Account Test !!!");

        click("open_account_btn_css");
        select("customer_select_css", data.get("customer"));
        select("currency_select_css", data.get("currency"));
        click("process_submit_btn_css");
        Thread.sleep(2000);
        
        acceptAlert(data.get("alertText"));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        alert.accept();

        logger.debug("EXECUTED: Open Account Test !!!");
        Reporter.log("EXECUTED: Open Account Test !!!");

    }

} // end class{}

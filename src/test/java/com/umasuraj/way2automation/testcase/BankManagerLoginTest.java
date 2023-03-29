package com.umasuraj.way2automation.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.umasuraj.way2automation.base.TestBase;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class BankManagerLoginTest extends TestBase {

    @Test
    public void bankManagerLoginTest() throws InterruptedException, IOException {

        logger.debug("INSIDE: Bank Manager Login Test !!!");

        //verifyEquals("xyz", "abc");
        click("bank_manager_login_btn_css");

        // Assert.assertTrue(isElementPresent(By.cssSelector(objectRepository.getProperty("add_customer_btn_css"))),"Login
        // Not Successful");
        Assert.assertTrue(isElementPresent("add_customer_btn_css"), "Login Not Successful");

        logger.debug("EXECUTED: Bank Manager Login Test !!!");
        Reporter.log("EXECUTED: Bank Manager Login Test !!!");
    }

}

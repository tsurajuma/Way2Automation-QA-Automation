/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umasuraj.way2automation.driver;

import static com.umasuraj.way2automation.base.TestBase.driver;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class Safari {
    public static WebDriver getDriver() {
        String driverLocation = Constant.SAFARI_DRIVER;
        File driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("Safari Driver Not Found");
            logger.debug("ERROR: Safari Driver Not Found !!!");
        }
        System.setProperty("webdriver.safari.driver", driverLocation);
        SafariOptions options = new SafariOptions();
//        options.addPreference("browser.startup.page", 1);
//        options.addPreference("browser.startup.homepage", "https://www.google.co.uk");
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(false);
        driver = new SafariDriver(options);

        logger.debug("INITIALIZED: Safari Driver !!!");

        return driver;
    } // end getDriver() 
} // end class{]

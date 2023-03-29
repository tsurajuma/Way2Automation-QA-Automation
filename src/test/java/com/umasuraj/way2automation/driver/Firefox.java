package com.umasuraj.way2automation.driver;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class Firefox extends TestBase {

    public static WebDriver getDriver() {
        String driverLocation = Constant.FIREFOX_DRIVER;
        File driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("Firefox Driver Not Found");
            logger.debug("ERROR: Firefox Driver Not Found !!!");
        }
        System.setProperty("webdriver.gecko.driver", driverLocation);
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.startup.page", 1);
        options.addPreference("browser.startup.homepage", "https://www.google.co.uk");
        options.setAcceptInsecureCerts(true);
        options.setHeadless(false);
        driver = new FirefoxDriver(options);

        logger.debug("INITIALIZED: Firefox Driver !!!");

        return driver;
    } // end getDriver() 

} // emd class{}

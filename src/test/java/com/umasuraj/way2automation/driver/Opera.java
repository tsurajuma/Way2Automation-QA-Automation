
package com.umasuraj.way2automation.driver;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.driver;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class Opera extends TestBase {
    public static WebDriver getDriver() {
        String driverLocation = Constant.OPERA_DRIVER;
        File driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("Opera Driver Not Found");
            logger.debug("ERROR: Opera Driver Not Found !!!");
        }
        System.setProperty("webdriver.opera.driver", driverLocation);
        OperaOptions options = new OperaOptions();
//        options.addPreference("browser.startup.page", 1);
//        options.addPreference("browser.startup.homepage", "https://www.google.co.uk");
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(false);
        driver = new OperaDriver(options);

        logger.debug("INITIALIZED: Opera Driver !!!");

        return driver;
    } // end getDriver() 
} // end class{}

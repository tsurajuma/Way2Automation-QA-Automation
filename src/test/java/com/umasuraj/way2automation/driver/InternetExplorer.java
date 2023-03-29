package com.umasuraj.way2automation.driver;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.driver;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class InternetExplorer extends TestBase {

    public static WebDriver getDriver() {
        String driverLocation = Constant.IE_DRIVER;
        File driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("Internet Explorer Driver Not Found");
            logger.debug("ERROR: Internet Explorer Driver Not Found !!!");
        }
        System.setProperty("webdriver.ie.driver", driverLocation);
        InternetExplorerOptions options = new InternetExplorerOptions();
//        options.addPreference("browser.startup.page", 1);
//        options.addPreference("browser.startup.homepage", "https://www.google.co.uk");
//        options.setAcceptInsecureCerts(true);
//        options.setHeadless(false);
        driver = new InternetExplorerDriver(options);

        logger.debug("INITIALIZED: Internet Explorer Driver !!!");

        return driver;
    } // end getDriver() 

} // end class{}

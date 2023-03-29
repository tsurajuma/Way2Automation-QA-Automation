package com.umasuraj.way2automation.driver;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.driver;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class PhantomJS extends TestBase {

    public static String driverLocation;
    public static File driverFile;
    public static InternetExplorerOptions options;

    public static WebDriver getDriver() {

        driverLocation = Constant.IE_DRIVER;
        driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("PhantomJS Driver Not Found");
            logger.debug("ERROR: PhantomJS Driver Not Found !!!");
        }

        System.setProperty("phantomjs.binary.path", driverLocation);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);

        //driver = new PhantomJSDriver(desiredCapabilities);

        logger.debug("INITIALIZED: Internet Explorer Driver !!!");

        return driver;

    } // end getDriver() 

} // end class{}

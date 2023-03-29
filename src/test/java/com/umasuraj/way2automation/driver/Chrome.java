package com.umasuraj.way2automation.driver;

import com.umasuraj.way2automation.base.TestBase;
import static com.umasuraj.way2automation.base.TestBase.logger;
import com.umasuraj.way2automation.utility.Constant;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class Chrome extends TestBase {

    public static WebDriver getDriver() {
        String driverLocation = Constant.CHROME_DRIVER;
        File driverFile = new File(driverLocation);
        if (!driverFile.exists()) {
            System.err.println("Chrome Driver Not Found");
            logger.debug("ERROR: Chrome Driver Not Found !!!");
        }
        System.setProperty("webdriver.chrome.driver", driverLocation);
        
        ChromeOptions options = new ChromeOptions();

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        options.setExperimentalOption("profile.default_content_setting_values.notifications", false);
//        options.setExperimentalOption("credentials_enable_service", false);
//        options.setExperimentalOption("profile.password_manager_enabled", false);
        options.setExperimentalOption("useAutomationExtension", false);

        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--homepage=about:blank");
        options.addArguments("--no-first-run");

        driver = new ChromeDriver(options);

        logger.debug("INITIALIZED: Chrome Driver !!!");

        return driver;
    } // end getDriver() 

}// end class{}

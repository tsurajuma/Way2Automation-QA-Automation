package com.umasuraj.way2automation.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.umasuraj.way2automation.driver.Chrome;
import com.umasuraj.way2automation.driver.Edge;
import com.umasuraj.way2automation.driver.Firefox;
import com.umasuraj.way2automation.driver.InternetExplorer;
import com.umasuraj.way2automation.driver.Opera;
import com.umasuraj.way2automation.driver.PhantomJS;
import com.umasuraj.way2automation.driver.Safari;
import com.umasuraj.way2automation.utility.Constant;
import com.umasuraj.way2automation.utility.ExcelReader;
import com.umasuraj.way2automation.utility.ExtentReportManager;
import com.umasuraj.way2automation.utility.TestUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class TestBase {

    /*
	 * This class initializes the following
	 * 
	 * WebDriver Properties Log ExtentReport Database Excel Mail ReportNG Jenkins
	 *
     */
    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties objectRepository = new Properties();
    public static FileInputStream fis;
    public static Logger logger = Logger.getLogger("devpinoyLogger");
    public static ExcelReader excelReader = new ExcelReader(Constant.TEST_DATA);
    public static WebDriverWait wait;
    public ExtentReports extentReports = ExtentReportManager.getInstance();
    public static ExtentTest extentTest;
    public static WebElement element;
    public static String browserName;
    public static String testSiteURL;
    public static int implicitWaitTime;

    @BeforeSuite
    public void setUp() {

        logger.debug("STARTED: Application SetUp");

        if (driver == null) {
            String configPropertiesFile = Constant.CONFIG_PROPERTIES;
            try {
                fis = new FileInputStream(configPropertiesFile);
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
            try {
                config.load(fis);

                logger.debug("LOADED: Config Properties File !!!");

            } catch (IOException e) {
                System.err.println(e);
            }

            String objectRepositoryPropertiesFile = Constant.OR_PROPERTIES;
            try {
                fis = new FileInputStream(objectRepositoryPropertiesFile);
            } catch (FileNotFoundException e) {
                System.err.println(e);
            }
            try {
                objectRepository.load(fis);

                logger.debug("LOADED: OR Properties File !!!");

            } catch (IOException e) {
                System.err.println(e);
            }

            browserName = config.getProperty("browser_name");
            switch (browserName) {
                case "firefox" ->
                    driver = Firefox.getDriver();
                case "chrome" ->
                    driver = Chrome.getDriver();
                case "ie" ->
                    driver = InternetExplorer.getDriver();
                case "phantomjs" ->
                    driver = PhantomJS.getDriver();
                case "edge" ->
                    driver = Edge.getDriver();
                case "opera" ->
                    driver = Opera.getDriver();
                case "safari" ->
                    driver = Safari.getDriver();
            }
            testSiteURL = config.getProperty("test_site_url");
            driver.get(testSiteURL);
            logger.debug("NAVIGATED: Browser to " + testSiteURL);
            driver.manage().window().maximize();
            logger.debug("MAXIMIZED: Browser Window !!!");
            implicitWaitTime = Integer.parseInt(config.getProperty("implicit_wait_time"));
            driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 5);

        }
    } // end setUp() method

    public WebElement locate(String locator) {

        element = null;

        if (locator.endsWith("_css")) {
            element = driver.findElement(By.cssSelector(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_xpath")) {
            element = driver.findElement(By.xpath(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_id")) {
            element = driver.findElement(By.id(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_name")) {
            element = driver.findElement(By.name(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_class")) {
            element = driver.findElement(By.className(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_tag")) {
            element = driver.findElement(By.tagName(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_linktext")) {
            element = driver.findElement(By.linkText(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_partial")) {
            element = driver.findElement(By.partialLinkText(objectRepository.getProperty(locator)));
        }

        logger.debug("LOCATED: [Web Element: " + locator + "] !!!");

        extentTest.log(LogStatus.INFO, "Located : " + locator);

        return element;

    } // end locate() method

    public void click(String locator) {

        if (locator.endsWith("_css")) {
            driver.findElement(By.cssSelector(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_xpath")) {
            driver.findElement(By.xpath(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_id")) {
            driver.findElement(By.id(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_name")) {
            driver.findElement(By.name(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_class")) {
            driver.findElement(By.className(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_tag")) {
            driver.findElement(By.tagName(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_linktext")) {
            driver.findElement(By.linkText(objectRepository.getProperty(locator))).click();

        } else if (locator.endsWith("_partial")) {
            driver.findElement(By.partialLinkText(objectRepository.getProperty(locator))).click();
        }

        logger.debug("CLICKED: [Web Element: " + locator + "] !!!");

        extentTest.log(LogStatus.INFO, "Clicking on : " + locator);
    }

    public void type(String locator, String value) {

        if (locator.endsWith("_css")) {
            driver.findElement(By.cssSelector(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_xpath")) {
            driver.findElement(By.xpath(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_id")) {
            driver.findElement(By.id(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_name")) {
            driver.findElement(By.name(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_class")) {
            driver.findElement(By.className(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_tag")) {
            driver.findElement(By.tagName(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_linktext")) {
            driver.findElement(By.linkText(objectRepository.getProperty(locator))).sendKeys(value);

        } else if (locator.endsWith("_partial")) {
            driver.findElement(By.partialLinkText(objectRepository.getProperty(locator))).sendKeys(value);
        }

        logger.debug("TYPED: in [Web Element : " + locator + "] [ENTERED VALUE: " + value + "] !!!");

        extentTest.log(LogStatus.INFO, "TYPED: in Web Element: " + locator + " ENTERED VALUE: " + value);

    } // end type() method

    public void select(String locator, String value) {

        element = null;

        if (locator.endsWith("_css")) {
            element = driver.findElement(By.cssSelector(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_xpath")) {
            element = driver.findElement(By.xpath(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_id")) {
            element = driver.findElement(By.id(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_name")) {
            element = driver.findElement(By.name(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_class")) {
            element = driver.findElement(By.className(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_tag")) {
            element = driver.findElement(By.tagName(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_linktext")) {
            element = driver.findElement(By.linkText(objectRepository.getProperty(locator)));

        } else if (locator.endsWith("_partial")) {
            element = driver.findElement(By.partialLinkText(objectRepository.getProperty(locator)));
        }

        Select select = new Select(element);
        select.selectByVisibleText(value);

        logger.debug("SELECTED: [Dropdown: " + locator + " VALUE: " + value + "] !!!");

        extentTest.log(LogStatus.INFO, "SELECTED: dropdown: " + locator + " VALUE: " + value);

    }

    public boolean isElementPresent(By by) {
        boolean flag = false;
        try {
            driver.findElement(by);
            flag = true;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    } // end isElementPresent() method

    public boolean isElementPresent(String locator) {
        WebElement element = null;
        boolean flag = false;
        try {
            element = locate(locator);
            flag = element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return flag;
    } // end isElementPresent() method

    public boolean isElementPresent(WebElement element) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return flag;
    } // end isElementPresent() method

    public void acceptAlert(String alertText) {
        Alert alert;
        logger.debug("WAITING: Alert to PopUp !!!");
        alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        alert.accept();
        logger.debug("ACCEPTED: Alert !!!");
    }

    public static void verifyEquals(String actual, String expected) throws IOException {

        try {

            Assert.assertEquals(actual, expected);
            logger.debug("VERIFICATION PASSED !!!");

        } catch (Throwable t) {

            logger.debug("VERIFICATION FAILED !!!");

            TestUtility.captureScreenshot();
            // ReportNG
            Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
            Reporter.log("<a target=\"_blank\" href=" + TestUtility.screenshotName + "><img src="
                    + TestUtility.screenshotName + " height=200 width=200></img></a>");
            Reporter.log("<br>");
            Reporter.log("<br>");
            // Extent Reports
            extentTest.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtility.screenshotName));

        }

    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        logger.debug("COMPLETED: Test Execution !!!");
    } // end tearDown() method

}

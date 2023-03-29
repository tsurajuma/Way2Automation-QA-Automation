package com.umasuraj.way2automation.listener;

import com.relevantcodes.extentreports.LogStatus;
import com.umasuraj.way2automation.base.TestBase;
import com.umasuraj.way2automation.utility.MonitoringMail;
import com.umasuraj.way2automation.utility.TestConfig;
import com.umasuraj.way2automation.utility.TestUtility;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class CustomListener extends TestBase implements ITestListener, ISuiteListener {

    public String messageBody;

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {

        System.setProperty("org.uncommons.reportng.escape-output", "false");
        try {
            TestUtility.captureScreenshot();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }

        logger.debug("FAILED: " + arg0.getName() + " !!!");

        extentTest.log(LogStatus.FAIL,
                arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
        extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(TestUtility.screenshotName));

        Reporter.log("Click to see Screenshot");
        Reporter.log("<a target=\"_blank\" href=" + TestUtility.screenshotName + ">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href=" + TestUtility.screenshotName + "><img src="
                + TestUtility.screenshotName + " height=200 width=200></img></a>");
        extentReports.endTest(extentTest);
        extentReports.flush();

    }

    @Override
    public void onTestSkipped(ITestResult arg0) {

        logger.debug("SKIPPED: " + arg0.getName() + " !!!");

        extentTest.log(LogStatus.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult arg0) {

        logger.debug("STARTED: " + arg0.getName() + " !!!");

        extentTest = extentReports.startTest(arg0.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {

        logger.debug("SUCCESS: " + arg0.getName() + " !!!");

        extentTest.log(LogStatus.PASS, arg0.getName().toUpperCase() + " PASS");
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    @Override
    public void onFinish(ISuite arg0) {

        MonitoringMail mail = new MonitoringMail();

        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }

        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (AddressException e) {
            System.err.println(e);
        } catch (MessagingException e) {

            System.err.println(e);
        }

    }

    @Override
    public void onStart(ISuite arg0) {

    }

} // end class{}

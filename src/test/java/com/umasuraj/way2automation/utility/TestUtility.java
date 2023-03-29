package com.umasuraj.way2automation.utility;

import com.umasuraj.way2automation.base.TestBase;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class TestUtility extends TestBase {

    public static String screenshotPath;
    public static String screenshotName;

    public static void captureScreenshot() throws IOException {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        screenshotName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        FileUtils.copyFile(screenshotFile, new File(Constant.SUREFIRE_REPORTS_DIR + screenshotName));
        logger.debug("TAKEN SCREENSHOT " + screenshotName + " !!!");

    }

    public static boolean isTestRunnable(String testName, ExcelReader excelReader) {

        boolean flag = false;
        String sheetName = "TestSuite";
        String testCaseName;
        String runMode;
        
        int rowCount = excelReader.getRowCount(sheetName);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

            testCaseName = excelReader.getCellData(sheetName, "testCaseName", rowNum);

            if (testCaseName.equalsIgnoreCase(testName)) {

                runMode = excelReader.getCellData(sheetName, "runMode", rowNum);

                if (runMode.equalsIgnoreCase("YES")) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        return flag;
    }

} // end class

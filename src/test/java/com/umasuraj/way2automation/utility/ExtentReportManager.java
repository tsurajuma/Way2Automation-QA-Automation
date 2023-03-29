package com.umasuraj.way2automation.utility;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class ExtentReportManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {

        if (extentReports == null) {

            extentReports = new ExtentReports(Constant.EXTENT_REPORTS_HTML, true, DisplayOrder.OLDEST_FIRST);
            extentReports.loadConfig(new File(Constant.EXTENT_REPORTS_CONFIG));

        }

        return extentReports;

    }

} // end class{}

package com.umasuraj.way2automation.utility;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class Constant {

    public static final String PROJECT_DIR = System.getProperty("user.dir");
    public static final String CONFIG_PROPERTIES = PROJECT_DIR + "\\src\\test\\resources\\properties\\Config.properties";
    public static final String OR_PROPERTIES = PROJECT_DIR + "\\src\\test\\resources\\properties\\OR.properties";

    public static final String CHROME_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\chrome\\110\\chromedriver.exe";
    public static final String FIREFOX_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\firefox\\geckodriver32.exe";
    public static final String IE_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\ie\\IEDriverServer32.exe";
    public static final String PHANTOMJS_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\phantomjs\\phantomjs.exe";
    public static final String OPERA_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\opera\\IEDriverServer32.exe";
    public static final String EDGE_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\edge\\edge.exe";
    public static final String SAFARI_DRIVER = PROJECT_DIR + "\\src\\test\\resources\\executable\\safari\\safari.exe";

    public static final String TEST_DATA = PROJECT_DIR + "\\src\\test\\resources\\excel\\testdata.xlsx";
    public static final String SUREFIRE_REPORTS_DIR = PROJECT_DIR + "\\target\\surefire-reports\\html\\";
    public static final String EXTENT_REPORTS_CONFIG = PROJECT_DIR + "\\src\\test\\resources\\extentconfig\\ExtentReportsConfig.xml";
    public static final String EXTENT_REPORTS_HTML = SUREFIRE_REPORTS_DIR + "\\extent.html";

}

package com.umasuraj.way2automation.rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.umasuraj.way2automation.utility.Constant;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class TestProperties {

    public static void main(String[] args) throws IOException {
        FileInputStream fis;

        Properties config = new Properties();
        String configPropertiesFile = Constant.CONFIG_PROPERTIES;
        fis = new FileInputStream(configPropertiesFile);
        config.load(fis);
        String browserName = config.getProperty("browser_name");
        System.out.println(browserName);

        Properties object = new Properties();
        String objectPropertiesFile = Constant.OR_PROPERTIES;
        fis = new FileInputStream(objectPropertiesFile);
        object.load(fis);
        String bankManagerLoginBtn = object.getProperty("bank_manager_login_btn");
        System.out.println(bankManagerLoginBtn);

    } // end main() method

} // end class{}

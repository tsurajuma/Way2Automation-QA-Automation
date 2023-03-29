package com.umasuraj.way2automation.utility;

import com.umasuraj.way2automation.base.TestBase;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.testng.annotations.DataProvider;

/**
 * @author Suraj Thirunavukkarasu
 * @since 02 March 2023
 * @version 1.0.0
 */
public class CommonDataProvider extends TestBase {

    @DataProvider(name = "commonDataProvider")
    public Object[][] getData(Method m) {

        String sheetName = m.getName();
        int rowCount = excelReader.getRowCount(sheetName);
        int colCount = excelReader.getColumnCount(sheetName);

        Object[][] data = new Object[rowCount - 1][1];
        Hashtable<String, String> table = null;
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) { // 2
            table = new Hashtable<String, String>();
            for (int colNum = 0; colNum < colCount; colNum++) {
                // data[0][0]
                String key = excelReader.getCellData(sheetName, colNum, 1);
                String value = excelReader.getCellData(sheetName, colNum, rowNum);
                table.put(key, value);
                logger.debug("FETCHED DATA SET: [Key: " + key + "] [Value: " + value + "] !!! ");
                data[rowNum - 2][0] = table;
            }
        }
        
        return data;
    } // end getData() method

} // end class{}

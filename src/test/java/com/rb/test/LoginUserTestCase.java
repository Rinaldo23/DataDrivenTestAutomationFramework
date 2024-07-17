package com.rb.test;

import com.rb.base.BaseClass;
import com.rb.pages.LoginPage;
import com.rb.utility.ExcelUtility;

/**
 * Test case to perform user login using data from an Excel sheet.
 */
public class LoginUserTestCase extends BaseClass {

    public static void main(String[] args) throws Exception {
        // Create an instance of LoginUserTestCase
        LoginUserTestCase ltc = new LoginUserTestCase();
        // Invoke the login test method
        ltc.LoginUser();
    }
    
    /**
     * Method to perform user login using data from Excel.
     * 
     * @throws Exception if any error occurs during the test.
     */
    public void LoginUser() throws Exception {
        // Launch the application
        LaunchApp();
        
        // Initialize page objects
        LoginPage lp = new LoginPage();
        ExcelUtility eu = new ExcelUtility();
        
        // Read user login credentials from Excel
        String[] userInfo = eu.readExcelData();
        
        // Enter login information using the retrieved data
        lp.EnterLoginInfo(userInfo);
        
        // Close the application
        CloseApp();
    }
}

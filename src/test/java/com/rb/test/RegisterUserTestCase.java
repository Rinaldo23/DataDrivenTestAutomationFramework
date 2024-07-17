package com.rb.test;

import com.rb.base.BaseClass;
import com.rb.pages.RegisterPage;
import com.rb.utility.ExcelUtility;

/**
 * Test case for registering a user using randommly generated data and writing it to an Excel sheet.
 */
public class RegisterUserTestCase extends BaseClass {

    public static void main(String[] args) throws Exception {
        // Create an instance of RegisterUserTestCase
        RegisterUserTestCase dd = new RegisterUserTestCase();
        // Invoke the user registration test method
        dd.RegisterUser();
    }
    
    /**
     * Method to register a user by entering data into a registration page and writing it to an Excel sheet.
     * 
     * @throws Exception if any error occurs during the test.
     */
    public void RegisterUser() throws Exception {
        // Launch the application
        LaunchApp();
        
        // Initialize page objects
        RegisterPage rp = new RegisterPage();
        ExcelUtility eu = new ExcelUtility();
        
        // Enter registration information and retrieve user details
        String[] userInfo = rp.EnterRegisterInfo();
        
        // Write user details to an Excel sheet
        eu.writeExcelData(userInfo);
        
        // Close the application
        CloseApp();
    }
}

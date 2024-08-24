package com.rb.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rb.base.BaseClass;
import com.rb.pages.LoginPage;
import com.rb.utility.ExcelUtility;

/**
 * Test case to perform user login using data from an Excel sheet.
 */
public class LoginUserDummyCase extends BaseClass {

	private LoginPage lp;
	private ExcelUtility eu;
	
	/**
	 * Initializes the test setup by creating instances of Faker and HelperClass,
	 * and generating the necessary test data for user operations.
	 */
	@BeforeEach
	public void setUp() {
		lp = new LoginPage();
		eu = new ExcelUtility();
	}
	

	/**
	 * Method to perform user login using data from Excel.
	 * 
	 * @throws Exception if any error occurs during the test.
	 */

	@Test
	public void LoginUser() throws Exception{
		// Read user login credentials from Excel
		String[] userInfo = eu.readExcelData();
		String email = userInfo[0];
		String password = userInfo[1];

		lp.enterEmail(email)
				.enterPassword(password)
				.clickOnLoginBtn()
				.isDashBoardLogoDisplayed()
				.verifySuccesfulLogin();
	}
}

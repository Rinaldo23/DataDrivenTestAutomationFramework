package com.rb.test;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.rb.base.BaseClass;
import com.rb.pages.LoginPage;
import com.rb.utility.ExcelUtility;

public class LoginWithMultipleUsersTest extends BaseClass {

	private LoginPage lp;
	private static ExcelUtility eu;

	/**
	 * Initializes the test setup by creating instances of LoginPage.
	 */
	@BeforeEach
	public void setUp() {
		lp = new LoginPage();
	}
	
	// Static block to initialize the ExcelUtility instance
	static {
	    eu = new ExcelUtility();
	}

	/**
	 * Parameterized test that logs in a user with the given email and password.
	 * 
	 * @param email    The email address of the user.
	 * @param password The password of the user.
	 */
	@ParameterizedTest
	@MethodSource("getAllUsersInfo")
	public void LoginUser(String email, String password) {
		lp.enterEmail(email)
		  .enterPassword(password)
		  .clickOnLoginBtn()
		  .isDashBoardLogoDisplayed()
		  .verifySuccesfulLogin();
	}

	/**
	 * Method to provide user information from an Excel file as a List of String arrays.
	 * 
	 * @return List of String arrays where each array contains email and password.
	 * @throws IOException if there is an error reading the Excel file.
	 */
	static List<String[]> getAllUsersInfo() throws IOException {
		return eu.readAllExcelData();
	}

}

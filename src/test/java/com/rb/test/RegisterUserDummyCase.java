package com.rb.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.rb.base.BaseClass;
import com.rb.pages.RegisterPage;
import com.rb.payload.User;
import com.rb.utility.ExcelUtility;

/**
 * Test case for registering a user using randomly generated data and writing it
 * to an Excel sheet.
 */
public class RegisterUserDummyCase extends BaseClass {

	private RegisterPage rp;
	private ExcelUtility eu;
	private Faker faker;
	private User userInfo;
	private List<String> userData; 

	/**
	 * Initializes the test setup by creating instances of Faker and HelperClass,
	 * and generating the necessary test data for user operations.
	 */
	@BeforeEach
	public void setUp() {
		faker = new Faker(); // Initialize Faker for generating random test data
		rp = new RegisterPage(); // Initialize Register Page
		eu = new ExcelUtility(); // Initialize Excel Utility
		userData = new ArrayList<String>();
		generateUserData(); // Generate random user data for the tests
		storeUserDataInExcel();
	}

	/**
	 * Generates random user data using the Faker library. This data will be used as
	 * payload for API requests in the tests.
	 */
	private void generateUserData() {
		userInfo = new User(); // Create a new User object
		userInfo.setFirstName(faker.name().firstName()); // Set a random first name
		userInfo.setLastName(faker.name().lastName()); // Set a random last name
		userInfo.setEmail(faker.internet().emailAddress()); // Set a random email address
		userInfo.setPhone(faker.number().randomNumber(10, true)); // Set a random phone number
		userInfo.setOccupation(faker.number().numberBetween(0, 4)); // Set a random occupation
		userInfo.setPassword(faker.internet().password(8, 10, true, true, true)); // Set a random password
	}
	
	private void storeUserDataInExcel() {
		userData.add(this.userInfo.getFirstName());
		userData.add(this.userInfo.getLastName());
		userData.add(this.userInfo.getEmail());
		userData.add(this.userInfo.getPhone());
		userData.add(this.userInfo.getOccupation());
		userData.add(this.userInfo.getPassword());
	}

	/**
	 * Method to register a user by entering data into a registration page and
	 * writing it to an Excel sheet.
	 * 
	 * @throws Exception if any error occurs during the test.
	 */
	@Test
	void RegisterUser() throws Exception {
		// Enter registration information and retrieve user details
		boolean userCreated = rp.navigateToRegisterPage()
				.enterfirstName(userInfo.getFirstName())
				.enterLastName(userInfo.getLastName())
				.enterEmail(userInfo.getEmail())
				.enterPhoneNumber(userInfo.getPhone())
				.selectOccupation(userInfo.getOccupation())
				.selectMaleGender()
				.enterPassword(userInfo.getPassword())
				.enterConfirmPassword(userInfo.getPassword())
				.agreePolicies()
				.clickOnRegisterBtn()
				.verifySuccesfulRegisteration()
				.verifyPageNavigatedToLoginPage();

		// Write user details to an Excel sheet
		try {
			if(userCreated) {
				eu.writeExcelData(userData);
			}else {
				throw new Exception("User Creation Unsuccessful");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

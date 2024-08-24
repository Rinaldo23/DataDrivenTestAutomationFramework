package com.rb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rb.base.BaseClass;
import com.rb.interactions.PageInteraction;
import com.rb.utility.DataGenerator;

/**
 * Page Object Class for the Register page.
 */
public class RegisterPage extends BaseClass {

	/**
	 * Initializes elements in the RegisterPage using PageFactory.
	 */
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// Web Elements

	@FindBy(id = "firstName")
	private WebElement firstNameTextBox;

	@FindBy(css = "input[id='lastName']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@type='text' and @id='userMobile']")
	private WebElement phoneNumberTextBox;

	@FindBy(css = "select[formcontrolname='occupation']")
	private WebElement occupationDropDown;

	@FindBy(css = "input[value='Male']")
	private WebElement maleRadioBtn;

	@FindBy(css = "input[value='Female']")
	private WebElement femaleRadioBtn;

	@FindBy(id = "userPassword")
	private WebElement passwordTextBox;

	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement agreeCheckBox;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement RegisterBtn;

	@FindBy(xpath = "//section/a[contains(text(), 'Register')]")
	private WebElement NavigateToRegisterPage;

	@FindBy(xpath = "//h1[normalize-space()='Account Created Successfully']")
	private WebElement accountCreationMsg;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement LoginBtn;

	DataGenerator dg = new DataGenerator();
	PageInteraction interaction = new PageInteraction();

	// Methods

	/**
	 * Generates random user details and enters them in the registration form.
	 * 
	 * @return An array containing user details: firstName, lastName, password,
	 *         phoneNumber, occupation, email
	 */

	public String[] EnterRegisterInfo() {

		String[] userDetails = new String[6];
		String[] occupationArr = new String[] { "Doctor", "Student", "Engineer", "Scientist" };

		String firstName, lastName, email, phoneNumber, occupation, password;

		// Generate random data
		firstName = dg.generateRandomString();
		lastName = dg.generateRandomString();
		email = dg.generateRandomEmail();
		phoneNumber = dg.generateRandomNumber();
		occupation = occupationArr[dg.generateRandomNumber(0, 4)];
		password = dg.generateRandomPassword();

		implicitWait(10); // Wait for elements to be interactable

		interaction.clickElement(NavigateToRegisterPage); // Click register link to navigate to registration page

		// Enter data into registration form
		interaction.inputText(firstNameTextBox, firstName);
		interaction.inputText(lastNameTextBox, lastName);
		interaction.inputText(emailTextBox, email);
		interaction.inputText(phoneNumberTextBox, phoneNumber);
		interaction.selectDropdownOptionByVisibleText(occupationDropDown, occupation);
		interaction.clickElement(maleRadioBtn);
		interaction.inputText(passwordTextBox, password);
		interaction.inputText(confirmPasswordTextBox, password);
		interaction.clickElement(agreeCheckBox);
		interaction.clickElement(RegisterBtn);

		// Check if account creation message is displayed
		if (interaction.checkIfElementExists(accountCreationMsg)) {
			String expectedMessage = "Account Created Successfully";
			String actualMessage = accountCreationMsg.getText().trim();
			actualMessage.equals(expectedMessage); // Compare expected and actual messages

			// Store user details in the array
			userDetails[0] = firstName;
			userDetails[1] = lastName;
			userDetails[2] = password;
			userDetails[3] = phoneNumber;
			userDetails[4] = occupation;
			userDetails[5] = email;
		}

		return userDetails;
	}

	/* Click register link to navigate to registration page */
	public RegisterPage navigateToRegisterPage() {
		interaction.clickElement(NavigateToRegisterPage);
		return this;
	}

	public RegisterPage enterfirstName(String firstName) {
		interaction.inputText(firstNameTextBox, firstName);
		return this;
	}

	public RegisterPage enterLastName(String lastName) {
		interaction.inputText(lastNameTextBox, lastName);
		return this;
	}

	public RegisterPage enterEmail(String email) {
		interaction.inputText(emailTextBox, email);
		return this;
	}

	public RegisterPage enterPhoneNumber(String phoneNumber) {
		interaction.inputText(phoneNumberTextBox, phoneNumber);
		return this;
	}

	public RegisterPage selectOccupation(String occupation) {
		interaction.selectDropdownOptionByVisibleText(occupationDropDown, occupation);
		return this;
	}

	public RegisterPage selectMaleGender() {
		interaction.clickElement(maleRadioBtn);
		return this;
	}

	public RegisterPage enterPassword(String password) {
		interaction.inputText(passwordTextBox, password);
		return this;
	}

	public RegisterPage enterConfirmPassword(String password) {
		interaction.inputText(confirmPasswordTextBox, password);
		return this;
	}

	public RegisterPage agreePolicies() {
		interaction.clickElement(agreeCheckBox);
		return this;
	}

	public RegisterPage clickOnRegisterBtn() {
		interaction.clickElement(RegisterBtn);
		return this;
	}

	public RegisterPage verifySuccesfulRegisteration() {
		String expectedMessage = "Account Created Successfully";
		String actualMessage = null;
		interaction.ExplicitWait(accountCreationMsg, 60);
		if (interaction.checkIfElementExists(accountCreationMsg)) {
			actualMessage = accountCreationMsg.getText().trim();
			interaction.compareText(actualMessage, expectedMessage);
		}
		return this;
	}

	public boolean verifyPageNavigatedToLoginPage() {
		interaction.ExplicitWait(LoginBtn, 30);
		interaction.clickElement(LoginBtn);

		return interaction.verifyPageNavigation("https://rahulshettyacademy.com/client/auth/login");
	}

}

package com.rb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rb.base.BaseClass;
import com.rb.interactions.PageInteraction;

/**
 * Page Object Class for the Login page.
 */
public class LoginPage extends BaseClass {

	/**
	 * Initializes elements in the LoginPage using PageFactory.
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Web Elements

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//h3[normalize-space()='Automation']")
	private WebElement logoImage;

	PageInteraction interaction = new PageInteraction();

	// Methods

	public LoginPage enterEmail(String email) {
		interaction.inputText(emailTextBox, email);
		return this;
	}

	public LoginPage enterPassword(String password) {
		interaction.inputText(passwordTextBox, password);
		return this;
	}

	public LoginPage clickOnLoginBtn() {
		interaction.clickElement(loginBtn);
		return this;
	}

	public LoginPage isDashBoardLogoDisplayed() {
		interaction.isElementDisplayed(logoImage);
		return this;
	}

	public void verifySuccesfulLogin() {
		interaction.verifyPageNavigation("https://rahulshettyacademy.com/client/dashboard/dash");
	}
}

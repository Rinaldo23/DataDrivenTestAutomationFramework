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

    /**
     * Enters login information into the login form.
     * 
     * @param data An array containing email at index 0 and password at index 1
     */
    public void EnterLoginInfo(String[] data) {
        implicitWait(10); // Wait for elements to be interactable
		
        interaction.inputText(emailTextBox, data[0]); // Input email
        interaction.inputText(passwordTextBox, data[1]); // Input password
        interaction.clickElement(loginBtn); // Click login button
		
        // Verify if the logo image is displayed after login
        if (logoImage.isDisplayed()) {
            String expectedUrl = "https://rahulshettyacademy.com/client/dashboard/dash";
            String actualUrl = driver.getCurrentUrl();
			
            actualUrl.equals(expectedUrl); // Compare expected and actual URLs
        }
    }
}

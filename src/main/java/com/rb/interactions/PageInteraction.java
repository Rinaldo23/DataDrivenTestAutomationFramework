package com.rb.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class for interacting with web elements on a page.
 */
public class PageInteraction {

    /**
     * Checks if the given WebElement is interactable (enabled and displayed).
     *
     * @param element The WebElement to check
     * @return true if the element is interactable, false otherwise
     */
    public boolean isElementInteractable(WebElement element) {
        return element.isEnabled() && element.isDisplayed();
    }

    /**
     * Inputs text into a WebElement after verifying it is interactable.
     *
     * @param element The WebElement to input text into
     * @param value   The text value to input
     * @throws IllegalArgumentException if the element is null or not interactable
     */
    public void inputText(WebElement element, String value) {
        try {
            if (element != null && isElementInteractable(element)) {
                element.clear(); // Clear any existing text
                element.sendKeys(value); // Input the new text
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Clicks on a WebElement after verifying it is interactable.
     *
     * @param element The WebElement to click
     * @throws IllegalArgumentException if the element is null or not interactable
     */
    public void clickElement(WebElement element) {
        try {
            if (element != null && isElementInteractable(element)) {
                element.click();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Selects a dropdown option by visible text after verifying the dropdown and text are interactable.
     *
     * @param element The dropdown WebElement to select from
     * @param text    The visible text of the option to select
     * @throws IllegalArgumentException if the element or text is null, or if the element is not interactable
     */
    public void selectDropdownOptionByVisibleText(WebElement element, String text) {
        try {
            if (element != null && text != null && isElementInteractable(element)) {
                Select options = new Select(element);
                options.selectByVisibleText(text);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Checks if an element exists and is interactable.
     *
     * @param element The WebElement to check for existence
     * @return true if the element exists and is interactable, false otherwise
     * @throws IllegalArgumentException if the element is null or not interactable
     */
    public boolean checkIfElementExists(WebElement element) {
        try {
            return element != null && isElementInteractable(element);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

}

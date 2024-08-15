package com.rb.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	/**
	 * Loads configuration properties from config.properties file.
	 *
	 * @throws Exception if there is an error loading the configuration file
	 */
	public void loadConfig() throws Exception {
		prop = new Properties();

		// Path to the config.properties file
		File config = new File(System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties");

		// Load properties from the file
		FileInputStream fis = new FileInputStream(config);
		prop.load(fis);
	}

	/**
	 * Sets up WebDriver, maximizes the window, and navigates to the application
	 * URL.
	 *
	 * @throws Exception if WebDriver setup or navigation fails
	 */
	@BeforeEach
	public void LaunchApp() throws Exception {
		loadConfig(); // Load configuration from config.properties

		// Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the URL specified in config.properties
		driver.get(prop.getProperty("url"));
	}

	/**
	 * Closes the WebDriver instance.
	 */
	@AfterEach
	public void CloseApp() {
		if (driver != null) {
			driver.quit(); // Quit the WebDriver instance
		}
	}

	/**
	 * Sets the implicit wait time for WebDriver operations.
	 *
	 * @param seconds the duration in seconds to wait implicitly
	 */
	public void implicitWait(long seconds) {
		if (driver != null) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
	}
	
}

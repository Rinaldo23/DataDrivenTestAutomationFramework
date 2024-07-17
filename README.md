# DataDrivenTestAutomationFramework

## Overview

DataDrivenTestAutomationFramework is a robust test automation framework designed for web application testing using Selenium WebDriver. The framework is structured to support data-driven testing and interaction with web elements, making it easy to maintain and extend.

## Features

- **Data-Driven Testing**: Utilize Excel files for input data.
- **Reusable Components**: Methods for common web interactions.
- **Page Object Model**: Organized structure for web elements and interactions.
- **Configurable Properties**: Easy configuration through `config.properties` file.

## Project Structure

```
DataDrivenTestAutomationFramework/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── rb/
│   │               ├── base/
│   │               │   └── BaseClass.java
│   │               ├── interactions/
│   │               │   └── PageInteraction.java
│   │               ├── pages/
│   │               │   ├── LoginPage.java
│   │               │   └── RegisterPage.java
│   │               └── utility/
│   │                   ├── DataGenerator.java
│   │                   └── ExcelUtility.java
│   └── test/
│       └── java/
│           └── com/
│               └── rb/
│                   └── test/
│                       ├── LoginUserTestCase.java
│                       └── RegisterUserTestCase.java
└── src/
    └── test/
        └── resources/
            ├── Configuration/
            │   └── config.properties
            └── TestData/
                └── ApplicationTestData.xlsx
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Selenium WebDriver
- Apache POI (for Excel interaction)
- ChromeDriver

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/DataDrivenTestAutomationFramework.git
   cd DataDrivenTestAutomationFramework
   ```

2. **Setup ChromeDriver:**
   Ensure you have ChromeDriver installed and configured in your system's PATH. Alternatively, WebDriverManager can be used to manage driver binaries automatically.

3. **Configure Properties:**
   Update the `config.properties` file with the correct URL and path to the Excel file:
   ```properties
   url=https://rahulshettyacademy.com/client
   excelFilePath=src/test/resources/TestData/DataDrivenTesting.xlsx
   ```

4. **Run the Tests:**
   Run the test cases using your IDE or Use the following Maven command to run the tests:
   ```sh
   mvn test
   ```

## Usage

- **Test Cases:** The test cases are located in the `com.rb.test` package. Each test case class extends `BaseClass` to inherit common setup and teardown methods.
- **Page Objects:** The `com.rb.pages` package contains classes representing web pages, with methods to interact with web elements.
- **Utilities:** The `com.rb.utility` package includes classes for data generation and Excel file interaction.

## Test Case Scenarios

### 1. Login User Test Case

This test case reads login credentials from an Excel file and attempts to log into the application. If the login is successful, the test will verify the current URL to ensure the user has navigated to the dashboard page.

### 2. Register User Test Case

This test case generates random user data, fills the registration form, and writes the user details to an Excel file if the registration is successful.

## Contributing

Contributions are welcome! Please create a pull request or raise an issue to discuss any changes.

## License

This project is licensed under the MIT License.

## Contact

For any queries, please contact rinaldobadigar@gmail.com.

---

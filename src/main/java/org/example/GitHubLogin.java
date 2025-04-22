package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GitHubLogin {
    public static void main(String[] args) {
        WebDriver driver = null; // Declare driver outside try block for finally clause
        try {
            // Set up Chrome driver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Navigate to the GitHub login page
            String loginUrl = "https://github.com/login?return_to=https%3A%2F%2Fgithub.com%2Fpublic-apis%2Fpublic-apis%2Fblob%2Fmaster%2FREADME.md";
            driver.get(loginUrl);

            // Maximize window
            driver.manage().window().maximize();

            // Wait for elements to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Find and fill username field
            WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login_field"))); // GitHub's username/email field ID
            usernameField.sendKeys("nlopez@gmail.com"); // Replace with your GitHub username or email

            // Find and fill password field
            WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))); // GitHub's password field ID
            passwordField.sendKeys("123456"); // Replace with your GitHub password

            // Find and click login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("commit"))); // GitHub's login button name
            loginButton.click();

           //Add a pause to see the result (for testing)
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Always close the driver
            if (driver != null) {
                driver.quit(); // Uncommented to ensure cleanup
            }
        }
    }
}








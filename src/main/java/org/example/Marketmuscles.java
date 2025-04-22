package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Marketmuscles {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();  // Auto-setup ChromeDriver
        WebDriver driver = new ChromeDriver();    // Launch Chrome browser

        // Navigate to MarketMuscles CRM login page
        driver.get("https://crm.marketmuscles.com/login");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Enter email on username field
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("nlopez@gmail.com");

        // Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("12345");
            Thread.sleep(3000);

        // Click on login button
        WebElement loginField = driver.findElement(By.xpath("//button[@type='submit']\n"));
        loginField.click();

        // Close the browser
//

    }
}


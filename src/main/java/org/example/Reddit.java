package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reddit {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();  // Auto-setup ChromeDriver
        WebDriver driver = new ChromeDriver();    // Launch Chrome browser

        // Navigate to Reddit
        driver.get("https://www.reddit.com/?rdt=61830/");


        // Maximize the browser window
        driver.manage().window().maximize();

        //login button use this xpath:
        //span[text()[normalize-space() = "Log In"]]
        driver.findElement(By.id("login-button")).click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src, 'login')]"));
        driver.switchTo().frame(iframe);
       //Enter email on username
        WebElement emailField = driver.findElement(By.name("Username"));
        emailField.sendKeys("nlopez@gmail.com");

        //Enter password on password field
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("12345");

        //Click on login button
        WebElement loginField = driver.findElement(By.name("//button[contains(text(), 'Log In')]"));

        loginField.click();

    }


}
        //CloseBrowser


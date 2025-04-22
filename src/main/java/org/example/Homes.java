package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homes {

    public static void main(String[] args) throws InterruptedException {

        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.homes.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Switch to the iframe
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signinframe")));
        driver.switchTo().frame(iframe);

        // Interact with elements inside iframe
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        usernameField.sendKeys("your@email.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("yourPassword123");

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }
}
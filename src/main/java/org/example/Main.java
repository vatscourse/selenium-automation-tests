package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Main {
        public static void main(String[] args) {


            WebDriverManager.chromedriver().setup();  // Auto-setup ChromeDriver
            WebDriver driver = new ChromeDriver();    // Launch Chrome browser

            driver.get("https://www.google.com");     // Navigate to Google
            System.out.println("Page Title: " + driver.getTitle());

            //driver.quit();
        }
}
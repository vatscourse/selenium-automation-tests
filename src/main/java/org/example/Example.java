package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
        public static void main(String[] args) {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            // Navigate to Google
            driver.get("https://www.google.com");

            // Find the search box and type
//            WebElement searchBox = driver.findElement(By.name("q"));
//            searchBox.sendKeys("Selenium WebDriver");

             driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

            // Submit the search form
//            searchBox.submit();



            // Close the browser
        driver.quit();
        }
    }



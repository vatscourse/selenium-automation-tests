package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();  // Auto-setup ChromeDriver
        WebDriver driver = new ChromeDriver();    // Launch Chrome browser




        //Navigate to Facebook
        driver.get("https://www.facebook.com/");

        //print the page title in the output
        System.out.println("The page title for this page is: " + driver.getTitle());


        // Close browser
        driver.quit();




    }
}

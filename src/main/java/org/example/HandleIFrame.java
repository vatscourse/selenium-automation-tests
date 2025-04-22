package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIFrame {
    public static void main(String[] args) {
        // setup chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // launching the website
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        // interacting with Iframe
        driver.switchTo().frame("frame1");
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println(heading.getText());
        // switching back to the website, or getting out of the iframe
        driver.switchTo().defaultContent();
        driver.quit();
    }

    }
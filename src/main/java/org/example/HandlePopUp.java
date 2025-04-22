package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class HandlePopUp {
    public static void main(String[] args) {
        // setup chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Launching the website
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();
        WebElement popUpButton = driver.findElement(By.id("showLargeModal"));
        popUpButton.click();
        driver.findElement(By.id("closeLargeModal")).click();
        // driver.quit();
    }


}
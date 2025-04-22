package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUp {

    public static void main(String[] args) {

        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //launching the website
        driver.get("https://demoqa.com/modal-dialogs");
        driver.manage().window().maximize();

        WebElement popUpButton = driver.findElement(By.xpath("//button[@id='showLargeModal']"));
        popUpButton.click();

        driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();


//driver.quit();

    }
}

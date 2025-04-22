package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("alialiali@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password@2232");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(text(), 'Log in')]")).click();

       // driver.quit();
    }
}
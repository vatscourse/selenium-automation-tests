package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFacebook {

    public static void main(String[] args) throws InterruptedException {

        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //Navigate to Facebook
        driver.get("https://www.facebook.com/");


        //Maximize the browser window
        driver.manage().window().maximize();

        //enter email in the username field
//        WebElement emailField = driver.findElement(By.xpath("//label[text()=\"Email Address\"]\n"));
//        emailField.click();
//        emailField.sendKeys("ali@gmail.com");
//
//        Thread.sleep(5000);
//        //enter password in the password field
//       WebElement passwordField =  driver.findElement(By.id("password"));
//       passwordField.sendKeys("123345");

        //Click on the Login Button
       WebElement loginButton =  driver.findElement(By.xpath("//button[contains(text(), 'Log In')]"));

       loginButton.click();



        //closes the current tab
        // driver.close();



        //closes the whole browser window
        // driver.quit();
    }

}

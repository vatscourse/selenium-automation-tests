package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdowns {

    public static void main(String[] args) {

        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.manage().window().maximize();

        driver.switchTo().frame("iframeResult");
        WebElement w = driver.findElement(By.xpath("//select[@id='cars']"));

        Select dropdown = new Select(w);

        dropdown.selectByIndex(1);

    }
}

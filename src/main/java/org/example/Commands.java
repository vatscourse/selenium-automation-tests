package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commands {

    public static void main(String[] args) {
        //setting up the chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //implicit wait, applies globally
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //navigate to Facebook
        driver.get("https://www.facebook.com/");
        driver.get("https://www.google.com/");


            //Explicit wait, for a specific element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")));

        element.click();  // only clicks after it's visible

        // .getText() gets the text of the element
        WebElement result = driver.findElement(By.xpath("//h2[@class='_8eso']"));
        System.out.println("The element text is: " + result.getText());

        boolean isVisible = result.isDisplayed();   // .isDisplayed() is the selenium command that shows
        // if an element is visible/displayed or not
        System.out.println("The element is " + isVisible);

        System.out.println(driver.getCurrentUrl()); //get current URL command
        System.out.println(driver.getTitle());  // get current Page title command
        driver.navigate().back(); // navigate back
        driver.navigate().forward(); //navigate forward
        driver.navigate().refresh();  //refresh the page command


        driver.quit();
    }
}

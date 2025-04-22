package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyFirstTest {



      WebDriver driver;

      @BeforeClass
        public void SetUp() {

          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
          driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          driver.manage().window().maximize();

      }

      @AfterClass
        public void tearDown() {
          driver.quit();
      }

      @Test
        public void testLogInToTheApplication () {

          driver.findElement(By.name("username")).sendKeys("Admin");
          driver.findElement(By.name("password")).sendKeys("admin123");
          driver.findElement(By.xpath("//button[@type='submit']")).click();

          String actualResult = driver.findElement(By.xpath("//p[contains(text(), 'mandaTocha userAlmeida')]")).getText();
          String expectedResult = "mandaTocha userdAlmeida";

            Assert.assertEquals(actualResult, expectedResult);


      }


    }


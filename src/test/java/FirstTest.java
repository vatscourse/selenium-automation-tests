import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Optional: Add Chrome options to reduce bot detection
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.dunkindonuts.com/en/sign-in");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogInToTheApplication() {
        try {
            // Create a WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


            // Locate and populate the email field
            By emailLocator = By.id("email"); // Update this after inspecting the page
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator)).sendKeys("niervanalopez@gmail.com");
            System.out.println("Email field populated.");

            // Check if there's a password field; if not, proceed with email-only flow
            By passwordLocator = By.id("password"); // Update this after inspecting the page
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator)).sendKeys("xyrvoj-9kurto-vomjAq");
                System.out.println("Password field populated.");
            } catch (Exception e) {
                System.out.println("No password field found, proceeding with email-only flow.");
            }

            // Locate and click the Sign in/Continue button
            By signInButtonLocator = By.xpath("//button[@type='submit']"); // Update this after inspecting the page
            wait.until(ExpectedConditions.elementToBeClickable(signInButtonLocator)).click();
            System.out.println("Sign in/Continue button clicked.");

            // Switch back to default content if an iframe was used
            driver.switchTo().defaultContent();

            // Verify the next step (e.g., redirect to a post-login page or "check email" page)
            wait.until(ExpectedConditions.urlContains("account")); // Update based on actual redirect URL
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("account"), "Failed to redirect to account page!");
            System.out.println("Redirected to account page successfully!");
        } catch (Exception e) {

        }}

    }
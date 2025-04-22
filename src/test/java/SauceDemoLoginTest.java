import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.time.Duration;

public class SauceDemoLoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Add Chrome options to run in incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogInAndCompleteCheckout() {
        try {
            // Create a WebDriverWait instance with a longer timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));

            // Locate and populate the username field
            By usernameLocator = By.id("user-name");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
            usernameField.clear();
            usernameField.sendKeys("standard_user");
            System.out.println("Username field populated with: " + usernameField.getAttribute("value"));

            // Locate and populate the password field
            By passwordLocator = By.id("password");
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
            passwordField.clear();
            passwordField.sendKeys("secret_sauce");
            System.out.println("Password field populated with: " + passwordField.getAttribute("value"));

            // Locate and click the Login button
            By loginButtonLocator = By.id("login-button");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
            try {
                loginButton.click();
                System.out.println("Login button clicked using regular click.");
            } catch (Exception e) {
                // Fallback to JavaScript click
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
                System.out.println("Login button clicked using JavaScript click.");
            }

            // Check for login error message (Sauce Demo displays errors with class="error-message-container")
            try {
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-container")));
                String errorText = errorMessage.getText();
                System.out.println("Login error: " + errorText);
                Assert.fail("Login failed with error: " + errorText);
            } catch (Exception e) {
                System.out.println("No login error message found, proceeding to verify redirect.");
            }

            // Print the current URL to debug the redirect
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after login attempt: " + currentUrl);

            // Verify redirect to the inventory page
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "Failed to redirect to inventory page!");
            System.out.println("Redirected to inventory page successfully!");

            // Directly navigate to the item page
            String itemPageUrl = "https://www.saucedemo.com/inventory-item.html?id=0";
            driver.get(itemPageUrl);
            System.out.println("Navigated directly to item page: " + itemPageUrl);

            // Verify the browser is on the item page
            wait.until(ExpectedConditions.urlToBe(itemPageUrl));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, itemPageUrl, "Failed to navigate to item page!");
            System.out.println("Successfully on item page!");

            // Verify the item name (optional, for confirmation)
            WebElement itemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
            Assert.assertEquals(itemName.getText(), "Sauce Labs Backpack", "Not on the correct item page!");
            System.out.println("Confirmed item page is for Sauce Labs Backpack.");

            // Locate and click the "Add to cart" button
            By addToCartButtonLocator = By.id("add-to-cart-sauce-labs-backpack");
            WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));
            try {
                addToCartButton.click();
                System.out.println("Clicked 'Add to cart' button using regular click.");
            } catch (Exception e) {
                // Fallback to JavaScript click
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
                System.out.println("Clicked 'Add to cart' button using JavaScript click.");
            }

            // Verify the item was added to the cart by checking the cart badge
            WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
            String cartItemCount = cartBadge.getText();
            Assert.assertEquals(cartItemCount, "1", "Item was not added to the cart!");
            System.out.println("Item added to cart successfully. Cart item count: " + cartItemCount);

            // Navigate to the cart page
            By cartLinkLocator = By.className("shopping_cart_link");
            WebElement cartLink = wait.until(ExpectedConditions.elementToBeClickable(cartLinkLocator));
            cartLink.click();
            System.out.println("Clicked cart link to navigate to cart page.");

            // Verify redirect to the cart page
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/cart.html", "Failed to navigate to cart page!");
            System.out.println("Navigated to cart page successfully!");

            // Verify the item is in the cart
            WebElement cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
            Assert.assertEquals(cartItemName.getText(), "Sauce Labs Backpack", "Sauce Labs Backpack not found in cart!");
            System.out.println("Confirmed Sauce Labs Backpack is in the cart.");

            // Click the "Checkout" button
            By checkoutButtonLocator = By.id("checkout");
            WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButtonLocator));
            checkoutButton.click();
            System.out.println("Clicked 'Checkout' button.");

            // Verify redirect to the checkout step one page
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-one.html"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html", "Failed to navigate to checkout step one page!");
            System.out.println("Navigated to checkout step one page successfully!");

            // Fill out the checkout form
            By firstNameLocator = By.id("first-name");
            WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLocator));
            firstNameField.sendKeys("John");
            System.out.println("First name field populated with: " + firstNameField.getAttribute("value"));

            By lastNameLocator = By.id("last-name");
            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLocator));
            lastNameField.sendKeys("Doe");
            System.out.println("Last name field populated with: " + lastNameField.getAttribute("value"));

            By postalCodeLocator = By.id("postal-code");
            WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeLocator));
            postalCodeField.sendKeys("12345");
            System.out.println("Postal code field populated with: " + postalCodeField.getAttribute("value"));

            // Click the "Continue" button
            By continueButtonLocator = By.id("continue");
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(continueButtonLocator));
            continueButton.click();
            System.out.println("Clicked 'Continue' button.");

            // Verify redirect to the checkout step two page
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-step-two.html"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-two.html", "Failed to navigate to checkout step two page!");
            System.out.println("Navigated to checkout step two page successfully!");

            // Verify the item is in the checkout overview
            WebElement checkoutItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));
            Assert.assertEquals(checkoutItemName.getText(), "Sauce Labs Backpack", "Sauce Labs Backpack not found in checkout overview!");
            System.out.println("Confirmed Sauce Labs Backpack is in the checkout overview.");

            // Click the "Finish" button
            By finishButtonLocator = By.id("finish");
            WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(finishButtonLocator));
            finishButton.click();
            System.out.println("Clicked 'Finish' button.");

            // Verify redirect to the checkout complete page
            wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/checkout-complete.html"));
            currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-complete.html", "Failed to navigate to checkout complete page!");
            System.out.println("Navigated to checkout complete page successfully!");

            // Verify the confirmation message
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
            Assert.assertEquals(confirmationMessage.getText(), "Thank you for your order!", "Checkout confirmation message not found!");
            System.out.println("Checkout completed successfully: " + confirmationMessage.getText());
        } catch (Exception e) {
            // Take a screenshot on failure
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
                FileUtils.copyFile(screenshot, new File("error-screenshot.png"));
                System.out.println("Screenshot saved as error-screenshot.png");
            } catch (Exception screenshotException) {
                System.out.println("Failed to take screenshot: " + screenshotException.getMessage());
            }
            System.out.println("Error during test: " + e.getMessage());
            throw e; // Re-throw to fail the test and see the error in TestNG
        }
    }
}
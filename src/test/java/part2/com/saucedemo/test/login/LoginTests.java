package part2.com.saucedemo.test.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class LoginTests extends BaseTest {


    @Test
    public void testLoginErrorMessage() {

        loginPage.setUsename("Standard_user");
        loginPage.setPassword("xxfdlfjw");
        loginPage.clickLoginButton();
       String actualMessage =  loginPage.getErrorMessage();

       Assert.assertTrue(actualMessage.contains("Epic sadface"));

    }
 }

package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");


    public void setUsename(String username) {
        set(usernameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton() {

        click(loginButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password) {

        setUsename(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {

        return find(errorMessage).getText();
    }
}

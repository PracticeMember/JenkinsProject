package com.project.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.common.BasePage;

public class Login extends BasePage{
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    public Login(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isInventoryPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
}
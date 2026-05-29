package com.project.pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.project.DriverSetup.DriverFactory;
import com.project.Utilities.Logger;
import com.project.common.BasePage;
import com.project.Utilities.*;
public class Login extends BasePage{
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    public Login(WebDriver driver) {
    	super(driver);
        this.driver = driver;
    }

    public void open() throws IOException {
        driver.get("https://www.saucedemo.com");
        Logger.log(Status.PASS,"Logged in");
        Logger.captureSnapshot(driver);
        new ImageCompressor(driver).compressImage();  
        Logger.log(Status.INFO,"Logged in");//#18c7ec
         
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        Logger.log(Status.PASS,"Entere username");
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        Logger.log(Status.PASS,"Entered Password");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
        Logger.captureSnapshot(driver);
        Logger.captureSnapshot(driver);
        Logger.captureSnapshot(driver);
        
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.captureSnapshot(driver);
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.captureSnapshot(driver);
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.captureSnapshot(driver);
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.captureSnapshot(driver);
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.captureSnapshot(driver);
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.log(Status.PASS,"Clicked Logged in");
        Logger.log(Status.PASS,"Clicked Logged in");
        int i=0;
        while(i<20) {
        	Logger.log(Status.PASS,"Clicked Logged in "+i);
        	i++;
        }
    }

    public boolean isInventoryPageDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }
    
}
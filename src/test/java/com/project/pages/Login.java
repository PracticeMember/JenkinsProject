package com.project.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.project.Utilities.Logger;
import com.project.Utilities.PropertyFileHandler;
import com.project.common.BasePage;

public class Login extends BasePage{

private WebDriver driver;
	
	public Login(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement SignIn;
	
	@FindBy(xpath="//span[text()='Customer Login']")
	WebElement customerLoginHeader;
	
	@FindBy(id="email")
	WebElement loginEmail;
	
	@FindBy(id="pass")
	WebElement loginPassword;
	
	@FindBy(name="send")
	WebElement signInBtn;

	@FindBy(className="logged-in")
	WebElement loginSuccess;

	public void clickSignInLink() {
		click(SignIn,"SignIn link");
	}

	public void verifyLoginpage() {
	   verifyIfElementPresent(customerLoginHeader,"Customer Login header");
	 
	}

	public void enterPassword() {
		String password=PropertyFileHandler.readProperty("loginPassword");
		sendText(loginPassword,password);
		Logger.captureSnapshot();
	}

	public void enterEmail() {
		String email=PropertyFileHandler.readProperty("loginEmail");
		sendText(loginEmail,email);
	}

	public void clickSignInBtn() {
		click(signInBtn,"Sign in button");
	}

	public void verifyPageAfterLogin() {
	    verifyIfElementPresent(loginSuccess,"Greeting Message after login");
	    Logger.captureSnapshot();
	    Logger.captureSnapshot();
	    Logger.captureSnapshot();
	}
	
}

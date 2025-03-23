package com.project.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.project.Utilities.Logger;
import com.project.common.BasePage;

import java.util.Random;

import  org.junit.Assert;

public class Register extends BasePage{

private WebDriver driver;
	
	public Register(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Create an Account']")
	WebElement createAccount;
	
	@FindBy(xpath="//a[text()='Create New Customer Account']")
	WebElement registrationHeader;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement  Email;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement signIn;
	
	@FindBy(xpath="//*[contains(text(),'Thank you for registering')]")
	WebElement registrationSuccess;
	
	String expectedTitle="Home Page";
	
	public void navigateToSite() {
		driver.get("https://magento.softwaretestingboard.com/");
		Assert.assertEquals("Page Title", driver.getTitle(), expectedTitle);
		Logger.log(Status.PASS, "Navigated to the site");
		Logger.captureSnapshot();
}

	public void enterFirstName(String firstname) {
		sendText(firstName,firstname);
		
	}

	public void enterPassword(String password) {
		sendText(Password,password);
	}

	public void confirmPassword(String password) {
		sendText(confirmPassword,password);
		Logger.captureSnapshot();
	}

	public void enterEmail(String email) {
		String chars="abcdefghijklmnopqrstuvwxyz0123456789";
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<6;i++) {
			int index=random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		email=sb.append(email).toString();
		sendText(Email,email);
	}

	public void enterLastName(String lastname) {
		sendText(lastName,lastname);
	}

	public void clickCreateAccountlink() {
		click(createAccount,"Create Account Link");
	}

	public void verifyRegistrationForm() {
	     verifyIfElementPresent(createAccount,"Create Account Header");
	     Logger.captureSnapshot();
	}

	public void verifyRegistrationSuccess() {
		 waitForElement(registrationSuccess);
		 verifyIfElementPresent(registrationSuccess,"Registration success message");
		 Logger.captureSnapshot();
	}

	public void clickSignIn() {
		 click(signIn,"SignIn button");
	}

}

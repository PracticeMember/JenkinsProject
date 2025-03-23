package com.project.StepDefinitions;

import com.project.DriverSetup.DriverFactory;
import com.project.pages.Login;

import io.cucumber.java.en.*;

public class LoginTest {

	Login login=new Login(DriverFactory.getDriver());
	
	@When("User clicks on Sign In link")
	public void user_clicks_on_sign_in_link() {
	    login.clickSignInLink();
	}

	@Then("login form would open")
	public void login_form_would_open() {
	    login.verifyLoginpage();
	}

	@Then("User would enter login email")
	public void user_would_enter_login_email() {
	   login.enterEmail();
	}

	@Then("User would enter login password")
	public void user_would_enter_login_password() {
	   login.enterPassword();
	}

	@Then("clicks on signIn button")
	public void clicks_on_sign_in_button() {
	  login.clickSignInBtn();
	}

	@Then("User should be able to land on homepage")
	public void user_should_be_able_to_land_on_homepage() {
	  login.verifyPageAfterLogin();
	}

}

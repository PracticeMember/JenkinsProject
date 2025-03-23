package com.project.StepDefinitions;

import com.project.DriverSetup.DriverFactory;
import com.project.Utilities.PropertyFileHandler;
import com.project.pages.Register;

import io.cucumber.java.en.*;

public class RegisterTest {
	
	Register register=new Register(DriverFactory.getDriver());
	
	@Given("User navigates to the magento website")
	public void user_navigates_to_the_magento_website() {
	   register.navigateToSite();
	}
	
	@When("User clicks on create an account link")
	public void user_clicks_on_create_an_account_link() {
	   register.clickCreateAccountlink();
	}
	
	@Then("registration form would open")
	public void registration_form_would_open() {
	   register.verifyRegistrationForm();
	}
	
	@Then("User would enter firstname")
	public void user_would_enter_firstname() {
		String firstName= PropertyFileHandler.readProperty("firstName");
		register.enterFirstName(firstName);
	}
	
	@Then("User would enter lastname")
	public void user_would_enter_lastname() {
		String lastName= PropertyFileHandler.readProperty("lastName");
		register.enterLastName(lastName);
	}
	
	@Then("User would enter email")
	public void user_would_enter_email() {
		String email= PropertyFileHandler.readProperty("email");
		register.enterEmail(email);
	}
	
	@Then("User would enter password and confirms it")
	public void user_would_enter_password_and_confirms_it() {
		String password= PropertyFileHandler.readProperty("password");
		register.enterPassword(password);
		register.confirmPassword(password);
	}
	@Then("clicks on signin button")
	public void clicks_on_signin_button() {
		//register.clickSignIn();
	}
	
	@Then("User should be able to see registration success message")
	public void user_should_be_able_to_see_registration_success_message() {
	   register.verifyRegistrationSuccess();
	}


}

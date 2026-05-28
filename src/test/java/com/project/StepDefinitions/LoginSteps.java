package com.project.StepDefinitions;

import com.project.DriverSetup.DriverFactory;
import com.project.pages.Login;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import java.util.Random;

public class LoginSteps {
    WebDriver driver=DriverFactory.getDriver();
    Login loginPage;

    @Given("I open the login page")
    public void i_open_the_login_page() throws Throwable{
       // driver = new ChromeDriver();
        loginPage = new Login(driver);
        loginPage.open();
    }

    @When("I enter valid {string} and {string}")
    public void i_enter_valid_credentials(String username,String password) throws Throwable{
    	Random random=new Random();
    	int n=random.nextInt(10)+1;
    	Thread.sleep(n*1000);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() throws Throwable{
    	Random random=new Random();
    	int n=random.nextInt(10)+1;
    	Thread.sleep(n*1000);
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() throws Throwable{
        assertTrue(loginPage.isInventoryPageDisplayed());
        driver.quit();
    }
    
}

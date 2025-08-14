package com.project.StepDefinitions;

import com.project.pages.Login;

import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class LoginSteps {
    WebDriver driver;
    Login loginPage;

    @Given("I open the login page")
    public void i_open_the_login_page() {
        driver = new ChromeDriver();
        loginPage = new Login(driver);
        loginPage.open();
    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void i_should_be_redirected_to_the_inventory_page() {
        assertTrue(loginPage.isInventoryPageDisplayed());
        driver.quit();
    }
}

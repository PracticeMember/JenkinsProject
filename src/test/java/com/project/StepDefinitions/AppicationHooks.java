package com.project.StepDefinitions;


import org.openqa.selenium.WebDriver;

import com.project.DriverSetup.DriverFactory;
import com.project.DriverSetup.WebDriverSetup;

import io.cucumber.java.*;

 public class AppicationHooks {
	    DriverFactory driverFactory = new DriverFactory();

	    @Before
	    public void setUp() {
	    	WebDriver driver=WebDriverSetup.createDriver();
	    	driverFactory.setDriver(driver);
	        
	    }

	    @After
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
	
}

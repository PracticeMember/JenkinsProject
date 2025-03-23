package com.project.StepDefinitions;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.project.DriverSetup.DriverFactory;
import com.project.Utilities.Context;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppicationHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private Context context;
	
	@Before
	public void setup(Scenario scenario){
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();
		context=new Context();
		context.setScenario(scenario);

	   driver.manage().deleteAllCookies();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(100));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	
	@After
	public void tearDown() {
		
		if(driver!=null)
		{
			context.removeScenario();
			driver.quit();	
		}
	}
	
}

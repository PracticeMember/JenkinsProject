package com.project.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features/Login.feature",
		glue = { "com.project.StepDefinitions" } ,//path of step definitions
		plugin ={"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/report.html"},
		monochrome=true
)
public class CucumberTest{

}

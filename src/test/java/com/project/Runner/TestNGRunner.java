package com.project.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "classpath:com/project/Features" , // path of  feature files
		glue = { "com.project.StepDefinitions" } ,//path of step definitions
		plugin ={"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/report.html"},
		monochrome=true
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

}
package com.project.Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/Features" , // path of  feature files
		glue = { "com.project.StepDefinitions" } ,//path of step definitions
		tags="@UserLogin",
		plugin ={"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/report.html"},
		monochrome=true
)
public class TestNGRunner extends AbstractTestNGCucumberTests{

//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
	
	//data-provider-thread-count="4"
}

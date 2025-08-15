package com.project.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.google.common.io.Files;
import com.project.DriverSetup.DriverFactory;

import io.cucumber.java.Scenario;

public class Logger {
  
	public static void log(Status status,String message) {
		String updatedMessage="";
		switch(status) {
		case PASS:
			updatedMessage= "<div class='Pass'>"+message+"</div>";
			break;
		case FAIL:
			updatedMessage= "<div class='Fail'>"+message+"</div>";
			//captureSnapshot();
			break;
		case INFO:
			updatedMessage= "<div class='Info'>"+message+"</div>";
			break;
		case SKIP:
			updatedMessage= "<div class='Skip'>"+message+"</div>";
			break;
		default: updatedMessage= message;break;
		}
		
		ExtentCucumberAdapter.getCurrentStep().log(status,updatedMessage);
		
	}
	
//	public static void captureSnapshot()  {
//		try {
//		Scenario scenario=Context.getScenario();
//		File screenshot= ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
//		byte[] content=FileUtils.readFileToByteArray(screenshot);
//		scenario.attach(content, "image/png","Image");
//		}
//		catch(Exception e) {
//		e.printStackTrace();
//		}
//	}
	
	public static String getDate() {
		DateFormat dateformat=new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		Date currentDate=new Date();
		String date=dateformat.format(currentDate).toString().replaceFirst(" ","_");
		return date;
	}
}

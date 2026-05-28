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

import com.aventstack.extentreports.MediaEntityBuilder;
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
	
	public static void captureSnapshot(WebDriver driver)  {
		try {
		File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String imagePath=System.getProperty("user.dir")+"//ss_"+getDate()+".png";
		
		String threadId = String.valueOf(Thread.currentThread().getId());
        String uniqueFileName = "ss_" + threadId + "_" + System.currentTimeMillis() + ".png";
        
        // 3. Define the full path
        String imagePath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots" + File.separator + uniqueFileName;
        FileUtils.copyFile(screenshot, new File(imagePath));
        String inlineHtmlLog = 
		    "<table style='width: 100%; border: none; background: transparent; margin: 0; padding: 0;'>" +
		    "  <tr style='background: transparent; border: none;'>" +
		    "    <td style='text-align: left; border: none; padding: 0 0 0 60px; vertical-align: middle; white-space: nowrap; color: #94a3b8;'>" +
		    "       - Image" +
		    "    </td>" +
		    "    <td style='text-align: right; border: none; padding: 0; vertical-align: middle; width: 85px;'>" +
		    "       <a data-featherlight='image' href='" + imagePath + "' style='cursor: zoom-in; display: inline-block;'>" +
		    "         <img src='" + imagePath + "' style='height: 28px; max-width: 80px; object-fit: contain; border-radius: 4px; border: 1px solid #334155; margin: 0; display: block;'/>" +
		    "       </a>" +
		    "    </td>" +
		    "  </tr>" +
		    "</table>";

		ExtentCucumberAdapter.getCurrentStep().info(inlineHtmlLog);
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	
	public static String getDate() {
		DateFormat dateformat=new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		Date currentDate=new Date();
		String date=dateformat.format(currentDate).toString().replaceFirst(" ","_");
		return date;
	}
}

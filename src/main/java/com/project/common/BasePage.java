package com.project.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.project.Utilities.Logger;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void click(WebElement element,String name) {
		try {
			element.click();
			Logger.log(Status.PASS,name+" object is clicked");
		}
		catch(Exception e) {
			Logger.log(Status.FAIL, String.format("Issue in clicking %s object", name));
			e.printStackTrace();
		}
	}
		
		public void sendText(WebElement element,String text) {
			try {
				element.sendKeys(text);
				Logger.log(Status.PASS, text+" is entered");
			}
			catch(Exception e) {
				Logger.log(Status.FAIL, String.format("Issue in entering %s text", text));
			}
	  }
		 
		public String getText(WebElement element) {
			try {
				return element.getText();
			}
			catch(Exception e) {
				Logger.log(Status.FAIL, "Issue in getting text from the element");
				e.printStackTrace();
			}
			return "";
		}
		
		public void verifyIfElementPresent(WebElement element, String message) {
			try {
			if(element.isDisplayed())
				Logger.log(Status.PASS, message+" is displayed");
			else 
				Logger.log(Status.FAIL, message+" is not displayed");
			}
			catch(Exception e) {
				Logger.log(Status.FAIL, message+" is not displayed due to exception");
				e.printStackTrace();
			}
		}
		
		public void waitForElement(WebElement element) {
			new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
		}
		
		public void addScreenshot() {
			
		}
}

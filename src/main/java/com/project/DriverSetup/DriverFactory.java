package com.project.DriverSetup;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.project.Utilities.PropertyFileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;

public class DriverFactory {


	public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();

	
	public WebDriver init_driver() {

		String browser= PropertyFileHandler.readProperty("browser");
		BrowserMobProxy proxy=new BrowserMobProxyServer();
		proxy.start(0);
		proxy.blacklistRequests(".*doubleclick.net.*", 200);
		proxy.blacklistRequests(".*googlesyndication.com.*", 200);
		Proxy selProxy=new Proxy();
		selProxy.setSslProxy("localhost:"+proxy.getPort());
			
		try {
		if (browser.equalsIgnoreCase("chrome")) {
		
			WebDriverManager.chromedriver().setup();	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-popup-blocking");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		    options.addArguments("--disable-notifications");// Disabling any notifications
		    options.addArguments("--ignore-certificate-errors");
		    options.setProxy(selProxy);
		    driverThread.set(new ChromeDriver(options));
		    ChromeDriverService service=new ChromeDriverService.Builder().build();
		    service.getUrl();
		   System.out.println(service.getUrl()+" is the port number");
		}
		
			else if (browser.equalsIgnoreCase("firefox")) {
			// firefox driver
		    WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-popup-blocking");
		    options.addArguments("--disable-notifications");// Disabling any notifications
		    options.addArguments("--ignore-certificate-errors");
		    options.setProxy(selProxy);
			
		    driverThread.set( new FirefoxDriver(options));
		
		}
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return getDriver();

	}

	public static synchronized WebDriver getDriver() {
		return driverThread.get();
	}
	

}

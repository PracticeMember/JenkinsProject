package com.project.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {

        System.out.println("Starting");

        WebDriver driver = new ChromeDriver();

        System.out.println("Browser opened");

        driver.get("https://google.com");
    }
}
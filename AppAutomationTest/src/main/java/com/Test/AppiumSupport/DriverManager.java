package com.Test.AppiumSupport;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

	public AppiumDriver<?> driver;
	public WebDriver driverWeb;
	public String udid;
	public String systemPort;
	public String platform;
	public String browser;
	AppiumDriverFactory obj = new AppiumDriverFactory();

	@Parameters({ "udid", "systemPort", "platform" })
	@BeforeMethod
	public void startDriver(String udid, String systemPort, String platform) {
		this.udid = udid;
		this.systemPort = systemPort;
		this.platform = platform;
		this.browser = "chrome";

		if (platform.equalsIgnoreCase("APP")) {
			driver = obj.getAppDriver(udid, systemPort);
			System.out.println("Driver: " + driver.toString());
		}
		if (platform.equalsIgnoreCase("WEB")) {
			driverWeb = obj.getWebDriver(browser);
			System.out.println("Driver: " + driverWeb.toString());
		}
	}

	@AfterMethod
	public void killDriver() {
		if (driver != null)
			driver.quit();
	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}

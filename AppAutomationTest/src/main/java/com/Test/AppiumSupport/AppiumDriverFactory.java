package com.Test.AppiumSupport;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumDriverFactory {

	public AppiumDriver<MobileElement> driver = null;
	public WebDriver driverWeb = null;

	public DesiredCapabilities capabilities = DesiredCapabilities.android();

	public AppiumDriver<?> getAppDriver(String udid, String systemPort) {
		try {
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			File apk = new File(System.getProperty("user.dir")+"/app/yatraapp.apk");
			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, udid);
			capabilities.setCapability(MobileCapabilityType.APP, apk);
			capabilities.setCapability(MobileCapabilityType.UDID, udid);
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
			capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yatra.base");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
					"com.yatra.base.activity.SplashScreenActivity");
			capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
			capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

			driver = new AndroidDriver<MobileElement>(url, capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	
	public WebDriver getWebDriver(String browser) {
		try {
			URL url = new URL("http://0.0.0.0:4723/wd/hub");
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + File.separator + "grid/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.setHeadless(false);
				options.addArguments("disable-infobars");
				options.addArguments("--start-maximized");

				driverWeb = new ChromeDriver(options);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return driverWeb;
	}

}

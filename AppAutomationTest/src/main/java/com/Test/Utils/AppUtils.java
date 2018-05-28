package com.Test.Utils;

import org.openqa.selenium.support.PageFactory;

import com.Test.CommonUtils.CommonFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppUtils {

	
	public AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(id="com.yatra.base:id/iv_1")
	private MobileElement appTutorialIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Flights']")
	private MobileElement appFlightIcon;
	
	@AndroidFindBy(id="com.yatra.base:id/iv_skip")
	private MobileElement appCancellationProtectionSkip;
	
	@AndroidFindBy(id="com.yatra.base:id/search_button")
	private MobileElement appFlightSearchBtn;
	
	public AppUtils(AppiumDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public boolean searchFlight() throws InterruptedException {
		boolean result = false;
		
		if(CommonFunctions.waitForAppElement(driver, 60, "id", "com.yatra.base:id/iv_1")) {
			appTutorialIcon.click();
			System.out.println("Clicked on tutorial icon");
		}
		
		if(CommonFunctions.waitForAppElement(driver, 60, "xpath", "//android.widget.TextView[@text='Flights']")) {
			appFlightIcon.click();
			System.out.println("Clicked on flight icon");
		}
		
		if(CommonFunctions.waitForAppElement(driver, 60, "id", "com.yatra.base:id/iv_skip")) {
			appCancellationProtectionSkip.click();
			System.out.println("Clicked on skip icon");
		}
		
		if(CommonFunctions.waitForAppElement(driver, 60, "id", "com.yatra.base:id/search_button")) {
			appFlightSearchBtn.click();
			System.out.println("Clicked on flight search button");
		}
		
		if(CommonFunctions.waitForAppElement(driver, 90, "id", "com.yatra.base:id/menu_filter_icon")) {
			result = true;
			System.out.println("Flight search results loaded");
		}
		
		return result;
	}
	
	
}

package com.Test.TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Test.AppiumSupport.DriverManager;
import com.Test.Utils.AppUtils;

public class TestApp extends DriverManager {
	AppUtils appObj;
	
	@Test(invocationCount=2)
	public void searchFlight() throws InterruptedException {
		boolean result = false;
		try {
			appObj = new AppUtils(driver);
			result = appObj.searchFlight();

		} finally {
			driver.quit();
			Assert.assertEquals(result, true);
		}
	}

	
}

package com.Test.TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Test.AppiumSupport.DriverManager;
import com.Test.Utils.WebUtils;

public class TestWeb extends DriverManager {
	WebUtils webObj;

	@Test(invocationCount=10)
	public void searchFlight() {
		boolean result = false;
		try {
			webObj = new WebUtils(driverWeb);
			result = webObj.searchFlightOnWebSite();
			
		} catch (Exception e) {
		} finally {
			driverWeb.quit();
			Assert.assertEquals(result, true);
		}
	}

}

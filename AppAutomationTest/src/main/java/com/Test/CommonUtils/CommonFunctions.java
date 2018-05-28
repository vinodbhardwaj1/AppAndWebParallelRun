package com.Test.CommonUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CommonFunctions {

	public static boolean waitForAppElement(AppiumDriver driver, int timeOutInSec, MobileElement element) {
		boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
			MobileElement elem = (MobileElement) wait.until(ExpectedConditions.visibilityOf(element));
			if (elem != null)
				result = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static boolean waitForAppElement(AppiumDriver driver, int timeOutInSec, String findBy, String locator) {
		boolean result = false;
		MobileElement elem=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
			if (findBy.equalsIgnoreCase("id")) {
				elem = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
			}else if (findBy.equalsIgnoreCase("xpath")) {
				elem = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			}
			if (elem != null)
				result = true;

		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public static void click(AppiumDriver driver, MobileElement element, int timeOutInSec) {
			element.click();
	}
}

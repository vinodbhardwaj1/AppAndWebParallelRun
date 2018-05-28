package com.Test.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class WebUtils {
	public WebDriver driver;
	
	@FindBy(id="BE_flight_origin_city")
	private WebElement webOriginCityBox;
	
	@FindBy(xpath="//div[@class='ac_results origin_ac']//li/div/p/span")
	private List<WebElement> webAutoSuggestionOrigin;
	
	@FindBy(id="BE_flight_arrival_city")
	private WebElement webDestinationCityBox;
	
	@FindBy(xpath="//div[@class='ac_results dest_ac']//li/div/p/span")
	private List<WebElement> webAutoSuggestionDestination;
	
	@FindBy(css="input[id='BE_flight_origin_date']")
	private WebElement webDepartDateBox;

	@FindBy(id="BE_flight_flsearch_btn")
	private WebElement webSearchBtn;
	
	@FindBy(css="div[class='matrix-slide-wrapper has-next-prev matrix-small-screen day-matrix-wrapper']")
	private WebElement webSrpMatrix;
	
	
	
	
	
	
	
	public WebUtils(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
	}
	
	
	public boolean searchFlightOnWebSite() throws InterruptedException {
		driver.get("http://www.yatra.com");
		System.out.println("Website launched");
		
		webOriginCityBox.click();
		System.out.println("Clicked on Origin city box");
		webOriginCityBox.sendKeys("DEL");
		Thread.sleep(1000);
		for(WebElement elem:webAutoSuggestionOrigin) {
			if(elem.getText().contains("DEL")) {
				elem.click();
				break;
			}
		}
		
		
		webDestinationCityBox.click();
		System.out.println("Clicked on Destination city box");
		webDestinationCityBox.sendKeys("HYD");
		Thread.sleep(1000);
		for(WebElement elem:webAutoSuggestionDestination) {
			if(elem.getText().contains("HYD")) {
				elem.click();
				break;
			}
		}
		
		//Not completed full test....just returned
		return true;
	}

}

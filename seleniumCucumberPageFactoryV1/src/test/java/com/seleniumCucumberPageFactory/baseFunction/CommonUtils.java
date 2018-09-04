package com.seleniumCucumberPageFactory.baseFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

	public static void clickOnWebElement(WebElement e) {

		e.click();

	}
	
	public static void clickOnWebElementJs(WebDriver driver, WebElement e) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", e);

	}


	public static void explicitWait(WebDriver driver, WebElement element) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		Thread.sleep(2000);
	}
	
	public static void waitFor(int ms) throws InterruptedException {
		
		Thread.sleep(ms);
	}
	

}


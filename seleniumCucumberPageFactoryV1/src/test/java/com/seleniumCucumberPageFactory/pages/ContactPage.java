package com.seleniumCucumberPageFactory.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;

public class ContactPage {
	
	//http://www.seleniumeasy.com/selenium-tutorials/page-factory-pattern-in-selenium-webdriver
	WebDriver driver;
	
	public ContactPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		   
	@FindBy(how=How.XPATH, using="//a[@title='Contact']") public WebElement contactLink ;
	@FindBy(how=How.XPATH, using="//input[@value='Send']") public WebElement send;
	@FindBy(how=How.XPATH, using="//input[@name='your-name']") public WebElement name;
	@FindBy(how=How.XPATH, using="//input[@name='your-email']") public WebElement email;
	@FindBy(how=How.XPATH, using="//input[@name='your-subject']") public WebElement subject;
	@FindBy(how=How.XPATH, using="//textarea[@name='your-message']") public WebElement message;
	@FindBy(how=How.XPATH, using="//*[@id='wpcf7-f375-p28-o1']/form/div[2]") public WebElement validationMessage;
	@FindBy(how=How.XPATH, using="//*[@id='wpcf7-f375-p28-o1']/form/div[2]") public WebElement dummy;
	

	public void goToRegistrationPage() {
		driver.navigate().to("https://www.google.com");
	}
	
	public void goToContactPage() {
		contactLink.click();
	}
	
}

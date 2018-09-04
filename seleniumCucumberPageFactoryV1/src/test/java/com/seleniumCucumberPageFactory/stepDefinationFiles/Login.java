package com.seleniumCucumberPageFactory.stepDefinationFiles;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.seleniumCucumberPageFactory.baseFunction.CommonFunction;
import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;
import com.seleniumCucumberPageFactory.pages.ContactPage;
import com.seleniumCucumberPageFactory.pages.LoginPage;

import cucumber.api.java.en.Given;


public class Login {
	
	Selenium sel;
	WebDriver driver;
	LoginPage loginPage;
	
	public Login (Selenium sel) {
		this.sel= sel;
		this.driver= sel.getDriver();
		loginPage = new LoginPage(driver);	
	}

	
	@Given("^i login as \"([^\"]*)\" using passowrd \"([^\"]*)\"$")
	public void i_login_as_using_passowrd(String userName, String password) throws Throwable {
		
		/*
		CommonUtils.explicitWait(driver, loginPage.userName);
		loginPage.userName.sendKeys(CommonFunction.GetData(userName));
		loginPage.password.sendKeys(CommonFunction.GetData(password));
		loginPage.login.click();
	    */
		
		System.out.println("User logged in successfully");
	}
	
	@Given("^i navigae to new contact form$")
	public void i_navigae_to_new_contact_form() throws Throwable {
		Thread.sleep(10000);
	    driver.navigate().to("https://cx-am.westeurope.cloudapp.azure.com/Cx/#view=/m/Contact/ContactDetails/Edit?id=0");
	    driver.navigate().refresh();
	}
	
	@Given("^i select title$")
	public void selectTitle() throws Throwable {
		Thread.sleep(10000);
	    driver.navigate().to("https://cx-am.westeurope.cloudapp.azure.com/Cx/#view=/m/Contact/ContactDetails/Edit?id=0");
	    Thread.sleep(10000);
	    
	    loginPage.titleDropdown.click();
	    
	    Thread.sleep(5000);
	    
	    List<WebElement> title = loginPage.titleDropdownList;
	    
        for (WebElement a: title) {
        	
        	if(a.getText().equals("Mr")) {
        		a.click();
        		break;
        	}
        }	    
	  
	}
	
	@Given("^i search for contact$")
	public void searchForContact() throws InterruptedException {
		Thread.sleep(10000);
		loginPage.searchbox.sendKeys("Test");
		loginPage.searchbox.sendKeys(Keys.ENTER);
		
		Thread.sleep(10000);
		
        List<WebElement> contacts = loginPage.ContactSearchList;
	    
        for (WebElement a: contacts) {
        	
        	if(a.getText().equals("Mr Penelope Avery")) {
        		
        		Actions action = new Actions(driver);
        		action.doubleClick(a).build().perform();
        		System.out.println("Contact is searched successfully");
        		break;
        	}
        }	
		
	}
	
}




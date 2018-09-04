package com.seleniumCucumberPageFactory.stepDefinationFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumCucumberPageFactory.baseFunction.CommonFunction;
import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;
import com.seleniumCucumberPageFactory.pages.ContactPage;
import com.seleniumCucumberPageFactory.pages.RegistrationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class Registration {
	
	Selenium sel;
	WebDriver driver;
	RegistrationPage registrationPage;
	
	public Registration(Selenium sel) {
		this.sel= sel;
		this.driver= sel.getDriver();
		registrationPage = new RegistrationPage(driver);	
	}
	
	@Given("^i am on registration page$")
	public void i_am_on_registration_page() throws Throwable {
		registrationPage.registerlink.click();

	}
	
	@And("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {
		registrationPage.submit.click();

	}
	
	@Given("^i fill the registration form$")
	public void i_fill_the_registration_form(DataTable table) throws Throwable {
		
		List<List<String>> data= table.raw();
		
		registrationPage.fname.sendKeys(data.get(1).get(0));
		registrationPage.lname.sendKeys(data.get(1).get(1));
		registrationPage.mstatus.click();
		registrationPage.hobby.click();
		registrationPage.country.click();
		registrationPage.dm.click();
		registrationPage.dd.click();
		registrationPage.dy.click();
		registrationPage.ph.sendKeys(data.get(1).get(2));
		registrationPage.uname.sendKeys(CommonFunction.generateString(8));
		registrationPage.email.sendKeys(CommonFunction.generateString(6)+"@gmail.com");
		registrationPage.about.sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		registrationPage.pw.sendKeys(data.get(1).get(3));
		registrationPage.cpw.sendKeys(data.get(1).get(4));
	
	}
	
	@Then("^I got registration success message$")
	public void i_got_registration_success_message() throws Throwable {
		String expectedValidation="Thank you for your registration";
	    Thread.sleep(5000);
		String actualvalidation= driver.findElement(By.xpath("//*[@id='post-49']/div/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
	}
	
	@Given("^i fill the registration form using ([^\"]*)$")
	public void i_fill_the_registration_form_using(String email) throws Throwable {
		registrationPage.fname.sendKeys("Tapi");
		registrationPage.lname.sendKeys("Kumari");
		registrationPage.mstatus.click();
		registrationPage.hobby.click();
		registrationPage.country.click();
		registrationPage.dm.click();
		registrationPage.dd.click();
		registrationPage.dy.click();
		registrationPage.ph.sendKeys("8271675498");
		registrationPage.uname.sendKeys(CommonFunction.generateString(8));
		registrationPage.email.sendKeys(email);
		registrationPage.about.sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		registrationPage.pw.sendKeys("password123");
		registrationPage.cpw.sendKeys("password123");

	}
	
	@Then("^I got validation error stating email already exists$")
	public void i_got_validation_error_stating_email_already_exists() throws Throwable {
       
		String expectedValidation="Error: E-mail address already exists";
	    Thread.sleep(5000);
		String actualvalidation= driver.findElement(By.xpath("//*[@id='post-49']/div/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
	}
	
	@Then("^I got validation error message for mandatory fields$")
	public void i_got_validation_error_message_for_mandatory_fields() throws Throwable {
		String actualvalidation=registrationPage.requiredField.getText();
		Assert.assertEquals("Checking mandatory field validation", "* This field is require", actualvalidation);
	}
		
}

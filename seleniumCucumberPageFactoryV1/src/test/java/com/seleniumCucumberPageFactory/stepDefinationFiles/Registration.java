package com.seleniumCucumberPageFactory.stepDefinationFiles;

import java.util.List;
import java.util.Map;

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
				
		Map<String, String> data = table.asMap(String.class, String.class);	
		
		registrationPage.fname.sendKeys(data.get("First Name"));
		registrationPage.lname.sendKeys(data.get("Last Name"));
		registrationPage.mstatus.click();
		registrationPage.hobby.click();
		registrationPage.country.click();
		registrationPage.dm.click();
		registrationPage.dd.click();
		registrationPage.dy.click();
		registrationPage.ph.sendKeys(data.get("Phone Number"));
		registrationPage.uname.sendKeys(CommonFunction.generateString(8));
		registrationPage.email.sendKeys(CommonFunction.generateString(6)+"@gmail.com");
		registrationPage.about.sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		registrationPage.pw.sendKeys(data.get("Password"));
		registrationPage.cpw.sendKeys(data.get("Confirm Password"));
	
	}
	
	@Given("^i fill the registration form with below details$")
	public void i_fill_the_registration_form_with_below_details(DataTable table) throws Throwable {
		
		Map<String, String> m = table.asMap(String.class, String.class);	
		System.out.println("First name is " + m.get("First Name"));
		System.out.println("Last name is " + m.get("Last Name"));
		System.out.println("Phone number is " + m.get("Phone Number"));
		System.out.println("Password is " + m.get("Password"));
		System.out.println("Last name is " + m.get("Confirm Password"));

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

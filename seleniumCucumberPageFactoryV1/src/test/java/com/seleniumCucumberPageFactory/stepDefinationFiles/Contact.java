package com.seleniumCucumberPageFactory.stepDefinationFiles;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.seleniumCucumberPageFactory.baseFunction.CommonFunction;
import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;
import com.seleniumCucumberPageFactory.pages.ContactPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class Contact {
	
	Selenium sel;
	WebDriver driver;
	ContactPage contactPage;
	
	public Contact(Selenium sel) {
		this.sel= sel;
		this.driver= sel.getDriver();
		contactPage = new ContactPage(driver);	
	}


	@Given("^I click on contact link$")
	public void i_click_on_link() throws Throwable {
		contactPage.goToContactPage();
	}
	
	
	@Given("^I click on Send button$")
	public void i_click_on_Send_button() {
		CommonUtils.clickOnWebElement(contactPage.send);
	}


	@Then("^I got validation error message$")
	public void i_got_validation_error_message() throws Throwable {
		String expectedValidation = "Validation errors occurred. Please confirm the fields and submit it again.";
		
		CommonUtils.explicitWait(driver, contactPage.validationMessage);
		String actulavalidation = contactPage.validationMessage.getText();
		Assert.assertEquals("Checking mandatory field validation123", expectedValidation, actulavalidation);
	}
	
	@Given("^I fill the contact form$")
	public void i_fill_the_contact_form() throws Throwable {
		contactPage.name.sendKeys("Kuldeep Kumar");
		contactPage.email.sendKeys("kuldeepkumar@gmail.com");
		contactPage.subject.sendKeys("Test Subject");
		contactPage.message.sendKeys("Test message");
	}
	
	@Then("^I got success message \"([^\"]*)\"$")
	public void i_got_success_message(String msg) throws Throwable {

		CommonUtils.explicitWait(driver, contactPage.validationMessage);
		String actulavalidation = contactPage.validationMessage.getText();

		Assert.assertEquals("Checking mandatory success msg", msg, actulavalidation);
	}
	
}

package com.seleniumCucumberPageFactory.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.seleniumCucumberPageFactory.baseFunction.Selenium;

public class RegistrationPage {
	
    WebDriver driver;
	
	public RegistrationPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//*[@id='menu-item-374']/a") public WebElement registerlink;
	@FindBy(how=How.XPATH, using="//input[@value='Submit']") public WebElement submit;
	@FindBy(how=How.XPATH, using="(//span[@class='legend error'])[1]") public WebElement requiredField;
	@FindBy(how=How.XPATH, using="//input[@name='first_name']") public WebElement fname;
	@FindBy(how=How.XPATH, using="//input[@name='last_name']") public WebElement lname;
	@FindBy(how=How.XPATH, using="//*[@id='pie_register']/li[2]/div/div/input[1]") public WebElement mstatus;
	@FindBy(how=How.XPATH, using="//*[@id='pie_register']/li[3]/div/div[1]/input[2]") public WebElement hobby;
	@FindBy(how=How.XPATH, using="//*[@id='dropdown_7']/option[81]") public WebElement country;
	@FindBy(how=How.XPATH, using="//*[@id='mm_date_8']/option[3]") public WebElement dm;
	@FindBy(how=How.XPATH, using="//*[@id='dd_date_8']/option[25]") public WebElement dd;
	@FindBy(how=How.XPATH, using="//*[@id='yy_date_8']/option[21]") public WebElement dy;
	@FindBy(how=How.XPATH, using="//input[@name='phone_9']") public WebElement ph;
	@FindBy(how=How.XPATH, using="//input[@name='username']") public WebElement uname;
	@FindBy(how=How.XPATH, using="//input[@name='e_mail']") public WebElement email;
	@FindBy(how=How.XPATH, using="//*[@id='profile_pic_10']") public WebElement pic;
	@FindBy(how=How.XPATH, using="//textarea[@name='description']") public WebElement about;
	@FindBy(how=How.XPATH, using="//input[@name='password']") public WebElement pw;
	@FindBy(how=How.XPATH, using="//*[@id='confirm_password_password_2']") public WebElement cpw;
	

	public static void navigateToGmail(WebDriver driver) throws IOException {
		
		driver.get("http://www.gmail.com");
		
	}
	
}

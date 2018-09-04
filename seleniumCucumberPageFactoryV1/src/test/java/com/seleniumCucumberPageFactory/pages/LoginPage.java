package com.seleniumCucumberPageFactory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	

    WebDriver driver;
	
    
	public LoginPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="#LoginModel_UserName") public WebElement userName ;
	@FindBy(how=How.CSS, using="#LoginModel_Password") public WebElement password ;
	@FindBy(how=How.CSS, using="#submit-login") public WebElement login ;
	@FindBy(how=How.XPATH, using="//span[contains(text(),'select')][1]") public WebElement titleDropdown ;
	@FindAll(@FindBy(how=How.CSS, using="[id*=ContactDetail_TitleId] > li")) public List<WebElement> titleDropdownList ;
	@FindAll(@FindBy(how=How.CSS, using="[role=rowgroup] > tr > td:nth-child(10)")) public List<WebElement> ContactSearchList ;
	@FindBy(how=How.CSS, using="[id=standardSearchPattern]") public WebElement searchbox ;
}

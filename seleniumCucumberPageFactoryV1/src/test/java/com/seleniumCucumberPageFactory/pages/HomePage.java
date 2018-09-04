package com.seleniumCucumberPageFactory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	 WebDriver driver;
		
	    
		public HomePage (WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(how=How.CSS, using="#quickMenuFilterBox") public WebElement quickMenuFilterBox ;
		@FindBy(how=How.CSS, using="#repair-company") public WebElement repairCompany ;
		@FindAll(@FindBy(how=How.CSS, using="[role=rowgroup] > tr > td:nth-child(10)")) public List<WebElement> ContactSearchList ;
		@FindBy(how=How.CSS, using="#system-case-sla-definition") public WebElement systemCaseSlaDefinitions ;


}

package com.seleniumCucumberPageFactory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ConfigurationPage {
	
	 WebDriver driver;
		
	    
		public ConfigurationPage (WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//Updated featureBranchName1
		//made some changes on featureBranchName1
		//Companies 
		@FindBy(how=How.CSS, using="#search-Company-text") public WebElement searchCompanyTextBox ;
		@FindBy(how=How.CSS, using="ul[id=treeview-CompanyResult]") public WebElement companyResult ;
		@FindAll(@FindBy(how=How.CSS, using="ul[id=treeview-CompanyResult] > li")) public List<WebElement> companyResultList ;
		@FindBy(how=How.CSS, using="#btnAddNewCompany") public WebElement newCompanyButton ;
		@FindBy(how=How.CSS, using="#CompanyModel_CompanyName_textarea") public WebElement companyNameTextBox ;
		@FindBy(how=How.CSS, using="span[aria-owns*=Drop_CompanyModel_DomainId_]") public WebElement domainDropdown ;
		@FindBy(how=How.CSS, using="a[title=Save]") public WebElement saveButton ;
		
		//SLA Definitions
		@FindBy(how=How.CSS, using="#searchSystemDefinition") public WebElement searchSlaDefinitionTextBox ;
		@FindBy(how=How.CSS, using="[id=user-definition-hierarchy]") public WebElement slaResult;
		@FindAll(@FindBy(how=How.CSS, using="[id=user-definition-hierarchy]  li")) public List<WebElement> slaResultList ;
		@FindBy(how=How.CSS, using="[id='SlaDefinitionModel_Description']") public WebElement SlaDescription;
		@FindBy(how=How.CSS, using="[aria-owns=SlaDefinition_Classifications_listbox] span[class='k-icon k-i-arrow-s']") public WebElement classificationArrowIcon;
		@FindBy(how=How.CSS, using="[id=classification-6]") public WebElement genericCaseClassificationListOption;
		@FindBy(how=How.CSS, using="[aria-owns=SlaDefinition_CompanyIds_listbox] span[class='k-icon k-i-arrow-s']") public WebElement companiesArrowIcon;
		@FindBy(how=How.CSS, using="[id=companies-1]") public WebElement anonyCompany1CompaniesListOption;
		@FindBy(how=How.CSS, using="[aria-owns=SlaDefinitionModel_SLACalendarId_listbox] span[class='k-icon k-i-arrow-s']") public WebElement calendarArrowIcon;
		@FindBy(how=How.CSS, using="[id=SlaDefinitionModel_SLACalendarId_listbox] li[data-offset-index='0']") public WebElement calendarDropbox1stOption;
		@FindBy(how=How.CSS, using="[aria-owns='SlaDefinitionModel_SLAPeriodUnitId_listbox'] span[class='k-icon k-i-arrow-s']") public WebElement slaUnitArrowIcon;
		@FindBy(how=How.CSS, using="[id='SlaDefinitionModel_SLAPeriodUnitId_listbox'] li[data-offset-index='3']") public WebElement slaUnitOptionWeek;
		
}

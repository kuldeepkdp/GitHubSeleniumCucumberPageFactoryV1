package com.seleniumCucumberPageFactory.stepDefinationFiles;

import org.openqa.selenium.WebDriver;

import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;
import com.seleniumCucumberPageFactory.pages.HomePage;
import com.seleniumCucumberPageFactory.pages.LoginPage;

import cucumber.api.java.en.Given;

public class Home {

	Selenium sel;
	WebDriver driver;
	HomePage homePage;

	public Home(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
		homePage = new HomePage(driver);
	}

	@Given("^I navigate to \"([^\"]*)\" configuration screen$")
	public void navigateToCompaniesConfigurationScreen(String screen) throws Throwable {

		CommonUtils.explicitWait(driver, homePage.quickMenuFilterBox);
		homePage.quickMenuFilterBox.sendKeys(screen);

		switch (screen) {

		case "Companies":
			
			homePage.repairCompany.click();
			break;

		case "System Case SLA Definitions":
			
			homePage.systemCaseSlaDefinitions.click();
			break;
			
		default: System.out.println("Mentoned screen is not available");

		}
		
	}

	@Given("^I navigate to System Case SLA Definitions configuration screen$")
	public void navigateToSystemCaseSlaDefinitionsConfigScreen() throws Throwable {

		CommonUtils.explicitWait(driver, homePage.quickMenuFilterBox);
		homePage.quickMenuFilterBox.sendKeys("System Case SLA Definitions");
		homePage.repairCompany.click();

	}

}

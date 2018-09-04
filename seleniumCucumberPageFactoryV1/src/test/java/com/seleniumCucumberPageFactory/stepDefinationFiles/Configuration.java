package com.seleniumCucumberPageFactory.stepDefinationFiles;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.seleniumCucumberPageFactory.baseFunction.CommonUtils;
import com.seleniumCucumberPageFactory.baseFunction.Selenium;
import com.seleniumCucumberPageFactory.pages.ConfigurationPage;

import cucumber.api.java.en.Given;

public class Configuration {

	Selenium sel;
	WebDriver driver;
	ConfigurationPage configurationPage;

	public Configuration(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
		configurationPage = new ConfigurationPage(driver);
	}

	@Given("^I check existence of company \"([^\"]*)\"$")
	public void isCompanyExist(String company) throws Throwable {

		int flag = 0;
		CommonUtils.explicitWait(driver, configurationPage.searchCompanyTextBox);
		configurationPage.searchCompanyTextBox.sendKeys(company);

		CommonUtils.explicitWait(driver, configurationPage.companyResult);
		List<WebElement> companyList = configurationPage.companyResultList;

		for (WebElement a : companyList) {

			if (a.getText().equals(company)) {

				flag = 1;

				System.out.println("Company exists");

			}
		}

		if (flag == 0) {

			String actualCompanyName = null;
			configurationPage.newCompanyButton.click();
			CommonUtils.explicitWait(driver, configurationPage.companyNameTextBox);
			configurationPage.companyNameTextBox.sendKeys(company);
			CommonUtils.explicitWait(driver, configurationPage.domainDropdown);
			configurationPage.domainDropdown.sendKeys("HAMQA");
			CommonUtils.explicitWait(driver, configurationPage.saveButton);
			configurationPage.saveButton.click();

			CommonUtils.explicitWait(driver, configurationPage.companyResult);
			List<WebElement> companyListUpdated = configurationPage.companyResultList;

			for (WebElement a : companyListUpdated) {

				if (a.getText().equals(company)) {

					actualCompanyName = a.getText();

				}
			}

			assertEquals(company, actualCompanyName);

		}

	}

	@Given("^I check existence of SLA Definition \"([^\"]*)\"$")
	public void isSlaDefinitionExists(String slaDefinition) throws Throwable {

		int isSlaDefinitionExists = 0;
		CommonUtils.explicitWait(driver, configurationPage.searchSlaDefinitionTextBox);
		configurationPage.searchSlaDefinitionTextBox.sendKeys(slaDefinition);
		CommonUtils.explicitWait(driver, configurationPage.slaResult);

		List<WebElement> slaList = configurationPage.slaResultList;

		for (WebElement a : slaList) {

			if (a.getText().equals(slaDefinition)) {

				isSlaDefinitionExists = 1;

				System.out.println("SlA definition exists " + a.getText());
				break;

			}
		}

		if (isSlaDefinitionExists == 0) {

			System.out.println("SlA definition does not exists ");
			configurationPage.SlaDescription.sendKeys(slaDefinition);
			configurationPage.classificationArrowIcon.click();
			CommonUtils.explicitWait(driver, configurationPage.genericCaseClassificationListOption);
			configurationPage.genericCaseClassificationListOption.click();
			configurationPage.classificationArrowIcon.click();
			CommonUtils.clickOnWebElementJs(driver, configurationPage.companiesArrowIcon);	
			CommonUtils.clickOnWebElementJs(driver, configurationPage.anonyCompany1CompaniesListOption);
			CommonUtils.clickOnWebElementJs(driver, configurationPage.companiesArrowIcon);
			CommonUtils.clickOnWebElementJs(driver, configurationPage.calendarArrowIcon);
			Thread.sleep(5000);
			CommonUtils.clickOnWebElementJs(driver, configurationPage.calendarDropbox1stOption);
			CommonUtils.clickOnWebElementJs(driver, configurationPage.slaUnitArrowIcon);
			CommonUtils.clickOnWebElementJs(driver, configurationPage.slaUnitOptionWeek);
			
		}
	}

}

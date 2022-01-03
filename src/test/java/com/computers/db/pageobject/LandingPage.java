package com.computers.db.pageobject;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.computers.db.drivers.DriverManager;
import com.computers.db.factory.ExplicitWaitFactory;

public class LandingPage extends BasePage{

	 private final By txtSearchbox = By.id("searchbox");
	 private final By btnSearchSubmit = By.id("searchsubmit");
	 private final By btnAddComputer = By.id("add");
	 private final By alertMessage = By.xpath("//div[@class='alert-message warning']");
	 
	 public void filterByComputerName(String name) {
		 ExplicitWaitFactory.waitForElementToBeVisible(txtSearchbox);
		 DriverManager.getDriver().findElement(txtSearchbox).sendKeys(name);
		 log.info(name + " is entered in search box");
		 DriverManager.getDriver().findElement(btnSearchSubmit).click();
		 log.info("Filter by Name button is clicked");
	 }
	 
	 public AddComputerPage clickAddNewComputer() {
		 ExplicitWaitFactory.waitForElementToBeClickable(btnAddComputer);
		 DriverManager.getDriver().findElement(btnAddComputer).click();
		 log.info("Add new computer button is clicked");
		 return new AddComputerPage();
	 }
	 
	 public void VerifyAlertMessage(String expectedMessage)
	 {
		 ExplicitWaitFactory.waitForElementToBeVisible(alertMessage);
		 String actualMessage = DriverManager.getDriver().findElement(alertMessage).getText();
		 Assert.assertEquals(actualMessage, expectedMessage);
		 log.info("Alert Message is verified: " + actualMessage);
	 }
}

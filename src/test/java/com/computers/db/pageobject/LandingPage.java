package com.computers.db.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.computers.db.drivers.DriverManager;
import com.computers.db.factory.ExplicitWaitFactory;

public class LandingPage extends BasePage{

	 private final By txtSearchbox = By.id("searchbox");
	 private final By btnSearchSubmit = By.id("searchsubmit");
	 private final By btnAddComputer = By.id("add");
	 private final By alertMessage = By.xpath("//div[@class='alert-message warning']");
	 private final By tableResults = By.xpath("//table[@class='computers zebra-striped']");
 
	 
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
	 
	 public void ClickOnTableValue(int rowNum, int colNum) {
		 ExplicitWaitFactory.waitForElementToBeVisible(tableResults);
		 WebElement cell = DriverManager.getDriver().findElement(By.xpath("//table[@class='computers zebra-striped']/tbody/tr["+rowNum+"]/td["+colNum+"]"));
		 String cellValue = cell.getText();
		 cell.click();
		 log.info(cellValue + " was clicked");
	 }
	 
	 public EditComputerPage ClickOnComputerNameInTable(String name) {
		 ExplicitWaitFactory.waitForElementToBeVisible(tableResults);
		 WebElement cell = DriverManager.getDriver().findElement(By.xpath("//a[text()='"+name+"']"));
		 String cellValue = cell.getText();
		 cell.click();
		 log.info(cellValue + " was clicked");
		 return new EditComputerPage();
	 }
}

package com.computers.db.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.computers.db.drivers.DriverManager;
import com.computers.db.factory.ExplicitWaitFactory;

public class EditComputerPage extends BasePage{
	private final By txtcomputerName = By.id("name");
	private final By btnSaveThisComputer = By.xpath("//input[@value='Save this computer']");
	
	
	public void editComputerName(String name) {
		ExplicitWaitFactory.waitForElementToBeVisible(txtcomputerName);
		WebElement txtName = DriverManager.getDriver().findElement(txtcomputerName);
		txtName.clear();
		txtName.sendKeys(name);
		log.info(name + " is entered in Computer name textbox");
		DriverManager.getDriver().findElement(btnSaveThisComputer).click();
		log.info("Save this computer button is clicked");
	}
	
}

package com.computers.db.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.computers.db.drivers.DriverManager;
import com.computers.db.factory.ExplicitWaitFactory;

public class AddComputerPage extends BasePage{
	
	private final By txtcomputerName = By.id("name");
	private final By txtIntroducedDate = By.id("introduced");
	private final By txtDiscontinuedDate = By.id("discontinued");
	private final By dropdownCompany = By.id("company");
	private final By btnCreateThisComputer = By.xpath("//input[@value='Create this computer']");
//	private final By btnCancel = By.xpath("//a[@class='btn']");

	public void addNewComputer(String name, String introducedDate, String discontinuedDate, String company)
	{
		ExplicitWaitFactory.waitForElementToBeVisible(txtcomputerName);
		DriverManager.getDriver().findElement(txtcomputerName).sendKeys(name);
		log.info(name + " is entered in Computer name textbox");
		DriverManager.getDriver().findElement(txtIntroducedDate).sendKeys(introducedDate);
		log.info(introducedDate + " is entered in Introduced textbox");
		DriverManager.getDriver().findElement(txtDiscontinuedDate).sendKeys(discontinuedDate);
		log.info(discontinuedDate + " is entered in Discontinued textbox");
		Select dropDown = new Select(DriverManager.getDriver().findElement(dropdownCompany));
        dropDown.selectByVisibleText(company);
        log.info(company + " is selected in Company dropdown");
		DriverManager.getDriver().findElement(btnCreateThisComputer).click();
		log.info("Create this computer button is clicked");
	}
	
	public void addNewComputer(String name)
	{
		ExplicitWaitFactory.waitForElementToBeVisible(txtcomputerName);
		DriverManager.getDriver().findElement(txtcomputerName).sendKeys(name);
		log.info(name + " is entered in Computer name textbox");
		DriverManager.getDriver().findElement(btnCreateThisComputer).click();
		log.info("Create this computer button is clicked");
	}
}

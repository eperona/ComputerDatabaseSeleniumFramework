package com.computers.db.testcases;

import org.testng.annotations.Test;
import com.computers.db.pageobject.AddComputerPage;
import com.computers.db.pageobject.LandingPage;

public class TC_001_AddNewComputer extends BaseTest{

	@Test
	public void addComputerJustNameTest() {
		LandingPage searchPage = new LandingPage();
		AddComputerPage addPage = searchPage.clickAddNewComputer();
		String computerName = "HP0001";
		addPage.addNewComputer(computerName);
		searchPage.VerifyAlertMessage("Done ! Computer "+computerName+" has been created");
	}
	
	@Test(dataProvider="TestData")
	public void addComputerCompleteTest(String name, String IntroducedDate, String DiscontinuedDate, String Company) {
		LandingPage searchPage = new LandingPage();
		AddComputerPage addPage = searchPage.clickAddNewComputer();
		addPage.addNewComputer(name, IntroducedDate, DiscontinuedDate, Company);
		searchPage.VerifyAlertMessage("Done ! Computer "+name+" has been created");
	}
}

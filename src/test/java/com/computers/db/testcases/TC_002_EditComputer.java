package com.computers.db.testcases;

import org.testng.annotations.Test;

import com.computers.db.pageobject.EditComputerPage;
import com.computers.db.pageobject.LandingPage;

public class TC_002_EditComputer extends BaseTest{

	@Test
	public void editComputerTest() {
		String name = "ARRA";
		String newName = name.concat(randomNumber(5));
		
		LandingPage searchPage = new LandingPage();
		searchPage.filterByComputerName(name);
		
		EditComputerPage editPage = searchPage.ClickOnComputerNameInTable(name);
		
		editPage.editComputerName(newName);
		searchPage.VerifyAlertMessage("Done ! Computer "+newName+" has been updated");
	}
}

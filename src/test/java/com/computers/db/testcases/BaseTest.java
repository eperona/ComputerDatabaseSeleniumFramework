package com.computers.db.testcases;


import java.io.IOException;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import com.computers.db.constants.FrameworkConstants;
import com.computers.db.drivers.DriverManager;
import com.computers.db.drivers.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.computers.db.utils.Excel;
import com.computers.db.utils.ReadConfig;

public class BaseTest {
	
	protected static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();
	public String baseURL=readconfig.getBaseUrl();

	@BeforeClass
	public void setUp() {
		Driver.setBrowserDriver();
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWait()));
        DriverManager.getDriver().get(baseURL);
		
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearUp() {
		Driver.quitBrowserDriver();
	}
	
	@DataProvider(name="TestData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/computers/db/testdata/TestData.xlsx";
		int rownum=Excel.getRowCount(path, "Sheet1");
		int colcount=Excel.getCellCount(path,"Sheet1",1);
		String testdata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				testdata[i-1][j]=Excel.getCellData(path,"Sheet1", i,j);//1 0
			}
		}
		return testdata;
	}
	
	public String randomString(int length)
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(length);
		return(generatedstring);
	}
	
	public static String randomNumber(int length) {
		String generatedString2 = RandomStringUtils.randomNumeric(length);
		return (generatedString2);
	}
	
	
}

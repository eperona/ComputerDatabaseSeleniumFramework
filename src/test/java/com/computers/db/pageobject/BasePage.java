package com.computers.db.pageobject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.computers.db.drivers.DriverManager;

public class BasePage {
	
	protected BasePage() {}

	protected static Logger log = LogManager.getLogger("computersdb");
	
	protected void executeJavaScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    protected void executeJavaScript(String script, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement e = DriverManager.getDriver().findElement(locator);
        js.executeScript(script, e);
    }

	public void captureScreen(String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}

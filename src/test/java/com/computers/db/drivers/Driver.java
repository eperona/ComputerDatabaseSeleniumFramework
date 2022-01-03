package com.computers.db.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.computers.db.enums.BrowserType;
import com.computers.db.utils.ReadConfig;

import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void setBrowserDriver() {
    	ReadConfig config = new ReadConfig();
        String browser = config.getBrowser();

        switch (BrowserType.valueOf(browser.toUpperCase().trim())) {
            case CHROME:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.chromedriver().setup();
                    DriverManager.setDriver(new ChromeDriver());
                }
                break;

            case EDGE:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.edgedriver().setup();
                    DriverManager.setDriver(new EdgeDriver());
                }
                break;

            case FIREFOX:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.firefoxdriver().setup();
                    DriverManager.setDriver(new FirefoxDriver());
                }
                break;

            default:
                throw new IllegalStateException("Invalid browser name: " + browser);
        }
    }

    public static void quitBrowserDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}


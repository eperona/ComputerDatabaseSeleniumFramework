package com.computers.db.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getBaseUrl() {
		return prop.getProperty("baseURL");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
}

package com.poc.api.automation.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {
	
	public static String currentWorkingDir = System.getProperty("user.dir");
	String ENVIRONMENT = System.getProperty("env");
	private Properties properties;
	private String propertyFilePath;

	
	public ConfigProvider(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(getPropertyFilePath()));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("application.properties " + propertyFilePath);
		}		
	}


	
	public String getPropertyFilePath() {
		
		if(ENVIRONMENT.equalsIgnoreCase("prod")) {			
			propertyFilePath = currentWorkingDir + "/src/test/resources/config/application-prod.properties";
		}
		
		else if(ENVIRONMENT.equalsIgnoreCase("dev")) {
			propertyFilePath = currentWorkingDir + "/src/test/resources/config/application-dev.properties";
		}
		else if(ENVIRONMENT.equalsIgnoreCase("test")) {
			propertyFilePath = currentWorkingDir + "/src/test/resources/config/application-test.properties";
		}
		else {
			propertyFilePath= currentWorkingDir + "/src/test/resources/config/application.properties";
		}
		
		return propertyFilePath;
	}
		
	
	
	public String getProperty(String propertyKey) {
		String propertyValue = properties.getProperty(propertyKey);
		if(propertyValue!= null) {
			return propertyValue;
		}
		else {
			throw new RuntimeException("Property Key: "
				 + propertyKey + " not specified in the application.properties file for env " + ENVIRONMENT );
		}		
	}

}

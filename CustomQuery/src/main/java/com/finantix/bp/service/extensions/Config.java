package com.finantix.bp.service.extensions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {

	private static Config single_instance = null;
	private static Properties prop = null;
	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	private static final String SERVER_CONFIG_DIR = "shared.config.dir";
	private static final String CONFIG_PROPERTIES = "wt_config.properties";

	static String result = "";
	static InputStream inputStream;

	public static Config getInstance() {
		if (single_instance == null) {
			single_instance = new Config();
			prop = loadConfig();
		}

		return single_instance;
	}

	public static String getPropValue(String key) {

		return prop.getProperty(key);
	}

	private static Properties loadConfig() {

		Properties prop = new Properties();
		
		
		try {
		InputStream input = new FileInputStream(System.getProperty(SERVER_CONFIG_DIR)+CONFIG_PROPERTIES);

			if (input == null) {
				logger.error("Sorry, unable to find "+Config.class.getClassLoader()+">>"+CONFIG_PROPERTIES);
				return prop;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			logger.error(prop.getProperty("SERVER"));
			logger.error(prop.getProperty("SERVER.SYS.USER"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	private static Properties loadConfiguration() {

		Properties prop = new Properties();
		
		
		
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES)) {

			if (input == null) {
				logger.error("Sorry, unable to find "+Config.class.getClassLoader()+">>"+CONFIG_PROPERTIES);
				return prop;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			logger.error(prop.getProperty("SERVER"));
			logger.error(prop.getProperty("SERVER.SYS.USER"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
	
	
	    public static void main(String args[]) 
	    { 
	        // instantiating Singleton class with variable x 
	    	Config config = Config.getInstance(); 
	    	config.getPropValue("SERVER");
	    }
	    
}

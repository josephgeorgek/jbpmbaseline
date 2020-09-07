package com.finantix.bp.service.extensions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Properties;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	private static final Logger logger = LoggerFactory.getLogger(Config.class);

	private static final String SERVER_CONFIG_DIR = "shared.config.dir";
	private static final String CONFIG_PROPERTIES = "/config.properties";
	private static final String PASSWORD = "password";
	private static final String SERVER = "server";
	private static final String USER = "user";
	public static final String SMSAPIKEY = "SMSAPIKEY";
	public static final String SMSAPISECRETKEY = "SMSAPISECRETKEY";
	
	static String result = "";
	static InputStream inputStream;

	

	public static String generatorRandom(int length) {

		Random obj = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = (char) (obj.nextInt(10) + 48);
		}

		logger.info("Generated Number : " + String.valueOf(otp));
		return String.valueOf(otp);
	}

	public static String getPropValue(String key) {

		try {
			Properties prop = new Properties();

			String fileName = System.getProperty(SERVER_CONFIG_DIR) + CONFIG_PROPERTIES;

			logger.info("fileName:" + fileName);

			FileInputStream fis = new FileInputStream(fileName);
			prop.load(fis);

			logger.info("prop:" + prop);

			Date time = new Date(System.currentTimeMillis());

			// get the property value and print it out
			String keyValue = prop.getProperty(key);

			result = keyValue;
			logger.info(key + "=" + keyValue + "\nProgram Ran on " + time);

		} catch (Exception e) {
			logger.error("Exception: " + e);
		}
		return result;
	}

}

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

public class Util {
	private static final Logger logger = LoggerFactory.getLogger(Util.class);

	private static final String JBOSS_SERVER_CONFIG_DIR = "jboss.server.config.dir";
	private static final String CONFIG_PROPERTIES = "/config.properties";
	private static final String PASSWORD = "password";
	private static final String SERVER = "server";
	private static final String USER = "user";



	static String result = "";
	static InputStream inputStream;

	public String getPropValues() throws IOException {

		try {
			Properties prop = new Properties();
			
			String fileName = System.getProperty(JBOSS_SERVER_CONFIG_DIR) + CONFIG_PROPERTIES;

			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}

			Date time = new Date(System.currentTimeMillis());

			// get the property value and print it out
			String user = prop.getProperty(USER);
			String server = prop.getProperty(SERVER);
			String password = prop.getProperty(PASSWORD);

			result = "server List = " + server + ", " + user + ", " + password;
			logger.error(result + "\nProgram Ran on " + time + " by user=" + user);

		} catch (Exception e) {
			logger.error("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public static String generatorOTP(int length) {

		
		Random obj = new Random();
		char[] otp = new char[length];
		for (int i = 0; i < length; i++) {
			otp[i] = (char) (obj.nextInt(10) + 48);
		}

		System.out.print(" OTP is : " + String.valueOf(otp));
		return String.valueOf(otp);
	}

	public String getPropValue(String key) throws IOException {

		try {
			Properties prop = new Properties();
		
			String fileName = System.getProperty(JBOSS_SERVER_CONFIG_DIR) + CONFIG_PROPERTIES;

			logger.error("fileName:" + fileName);

			FileInputStream fis = new FileInputStream(fileName);
			prop.load(fis);

			logger.error("prop:" + prop);

			Date time = new Date(System.currentTimeMillis());

			// get the property value and print it out
			String keyValue = prop.getProperty(key);

			result = keyValue;
			logger.error(key + "=" + keyValue + "\nProgram Ran on " + time);

		} catch (Exception e) {
			logger.error("Exception: " + e);
		}
		return result;
	}

}

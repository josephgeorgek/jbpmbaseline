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

		return String.valueOf(otp);
	}

	public static String getPropValue(String key) {

	
		return key;
	}

}

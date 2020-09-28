package com.finantix.bp.service.extensions;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.process.workitem.rest.RESTServiceException;
import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateOTP extends RESTWorkItemHandler {

	private static final String AUTHORIZE = " Use it to authorize the change";
	private static final String AUTHORIZATION_CODE = "Authorization code:";
	private static final String METHOD = "Method";
	private static final String URL = "Url";
	private static final String CONTENT_TYPE = "ContentType";
	private static final String APPLICATION_JSON = "application/json";
	private static final String HEADERS = "Headers";
	private static final String CONTENT_DATA = "ContentData";
	private static final String FTX_HEADER = "ContentType=application/jsonAccept=application/json;Content-Type=application/json;X-Requested-With=XmlHttpRequest";
	private static final String POST = "POST";
	private static final String NUMBER = "number";
	private static final String ORG = "finantix";
	private static final String TENANTID = "1";
	private static final String PASSWORD = "password";
	private static final String USER = "admin@thedigitalstack.com";
	private static final String SERVER = "http://prd-inn-as-01.fx.lan:8181";
	private static final String GENERATE_OTP = "GenerateOTP v1.0.1";
	private static final String HTTPS_REST_NEXMO_COM_SMS_JSON = "https://rest.nexmo.com/sms/json";
	private static final String RESULTS_VALUE = "OTP";

	String serverURL = "/rest/otp/generate?Return-Token=true";

	private static final Logger logger = LoggerFactory.getLogger(GenerateOTP.class);

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		logger.error(GENERATE_OTP);
		WorkItemImpl customworkItem = new WorkItemImpl();

		String useremail = "joseph.george@finanitx.com"; // get it from workflow
		String number = "6591052920"; // get it from workflow
		String jsonString = "";

		try {

			jsonString = "{\"tenant\":\"" + TENANTID + "\",\"username\":\"" + USER + "\",\"email\":\"" + useremail
					+ "\",\"locale\":\"en\"}";

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		Map<String, Object> orignalparams = workItem.getParameters();
		logger.error("executeWorkItem orignalparams : " + orignalparams);

		customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, USER);
		customworkItem.setParameter(Constants.LPASS, PASSWORD);
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);
		customworkItem.setParameter(URL, SERVER + serverURL);
		customworkItem.setParameter(METHOD, POST);
		customworkItem.setParameter(CONTENT_DATA, jsonString);
		customworkItem.setParameter(HEADERS, FTX_HEADER);

		logger.error("executeWorkItem getParameters : " + customworkItem.getParameters());
		super.executeWorkItem(customworkItem, manager);

		String random = Config.generatorRandom(4);
		String message = AUTHORIZATION_CODE + random + AUTHORIZE;
		jsonString = "{\"from\": \"" + ORG + "\",\"text\": \"" + message + "\",\"to\": \"" + number
				+ "\",\"api_key\": \" " + Config.getPropValue(Config.SMSAPIKEY) + " \",\"api_secret\": \" "
				+ Config.getPropValue(Config.SMSAPISECRETKEY) + "  \"}";
		customworkItem.setParameter(CONTENT_DATA, jsonString);
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);
		customworkItem.setParameter(URL, HTTPS_REST_NEXMO_COM_SMS_JSON);
		customworkItem.setParameter(METHOD, POST);
		logger.error("executeWorkItem 2 getParameters : " + customworkItem.getParameters());
		super.executeWorkItem(customworkItem, manager);
		results.put(RESULTS_VALUE, random);
		logger.error("executeWorkItem DONE : " + results);
		manager.completeWorkItem(workItem.getId(), results);
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		super.abortWorkItem(workItem, manager);
	}

	private ClassLoader classLoader;

	Map<String, Object> results = null;

	@Override
	protected void postProcessResult(String result, String resultClass, String contentType,
			Map<String, Object> results) {

		logger.error("postProcessResult  result: " + result);

		if (!StringUtils.isEmpty(resultClass) && !StringUtils.isEmpty(contentType)) {
			try {
				Class<?> clazz = Class.forName(resultClass, true, classLoader);
				Object resultObject = transformResult(clazz, contentType, result);

				results.put(PARAM_RESULT, resultObject);
			} catch (Throwable e) {
				throw new RuntimeException("Unable to transform respose to object", e);
			}
		} else {

			results.put(PARAM_RESULT, result);
		}
		logger.error("postProcessResult executeWorkItem  results: " + results);
		this.results = results;

	}

}

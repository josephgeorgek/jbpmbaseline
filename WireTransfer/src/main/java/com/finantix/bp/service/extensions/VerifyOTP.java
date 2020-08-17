package com.finantix.bp.service.extensions;


import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;



import java.util.Map;


import org.drools.core.process.instance.impl.WorkItemImpl;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;

public class VerifyOTP extends RESTWorkItemHandler {

	private static final String DEFAULT = "6591052920";
	private static final String FINANTIX = "finantix";
	private static final String VERIFY_OTP = "VerifyOTP v1.3.8";
	String serverURL = "/rest/otp/generate/";
	String user = null;
	String password = null;
	String host = null;
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
	private static final String ORG = "org";
	private static final String TENANTID = "tenantid";
	private static final String USEREMAIL = "useremail";
	private static final String PASSWORD = "password";
	private static final String USER2 = "user";
	private static final String SERVER = "server";
	private static final Logger logger = LoggerFactory.getLogger(VerifyOTP.class);
	

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		logger.error(VERIFY_OTP);
		WorkItemImpl customworkItem = new WorkItemImpl();
	    String useremail = "";
		String tenantid = "";
		String from = FINANTIX;
		String number = DEFAULT;
		String jsonString = "";
		com.finantix.bp.service.extensions.Util util = new com.finantix.bp.service.extensions.Util();
		try {
			host = util.getPropValue(SERVER);
			user = util.getPropValue(USER2);
			password = util.getPropValue(PASSWORD);
			useremail = util.getPropValue(USEREMAIL);
			tenantid = util.getPropValue(TENANTID);

			from = util.getPropValue(ORG);
			number = util.getPropValue(NUMBER);
				jsonString = "{\"tenant\":\"" + tenantid + "\",\"username\":\"" + user + "\",\"email\":\"" + useremail
					+ "\",\"locale\":\"en\"}";

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		Map<String, Object> orignalparams = workItem.getParameters();
		logger.error("executeWorkItem orignalparams : " + orignalparams);
		customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, user);
		customworkItem.setParameter(Constants.LPASS, password);
		;
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);
		customworkItem.setParameter(URL, host + serverURL);
		customworkItem.setParameter(METHOD, POST);

		ObjectMapper mapper = new ObjectMapper();

		customworkItem.setParameter(CONTENT_DATA, jsonString);

		customworkItem.setParameter(HEADERS, FTX_HEADER);

		logger.error("executeWorkItem getParameters : " + customworkItem.getParameters());

		super.executeWorkItem(customworkItem, manager);

		customworkItem.setParameter(CONTENT_DATA, jsonString);

		customworkItem.setParameter(HEADERS, FTX_HEADER);

		logger.error("executeWorkItem getParameters : " + customworkItem.getParameters());

		super.executeWorkItem(customworkItem, manager);

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

				logger.error("postProcessResult executeWorkItem  result: " + result + "clazz:" + clazz);

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

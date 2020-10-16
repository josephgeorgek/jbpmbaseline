package com.finantix.bp.service.extensions;

import java.util.Map;

import org.drools.core.process.instance.impl.WorkItemImpl;
import org.drools.core.util.StringUtils;
import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerifyOTP extends RESTWorkItemHandler {

	private static final String USER_EMAIL = "user_email";
	private static final String TOKEN = "token";
	private static final String USER = "user";
	private static final String SERVER = "SERVER";
	private static final String SERVER_USER = "SERVER.SYS.USER";
	private static final String SERVER_PASSWORD = "SERVER.SYS.PASSWORD";
	private static final String API_OTP_VALIDATE = "API.OTP.VALIDATE";
	private static final String TENANT_ID = "tenant_id";
	private static final String METHOD = "Method";
	private static final String URL = "Url";
	private static final String CONTENT_TYPE = "ContentType";
	private static final String APPLICATION_JSON = "application/json";
	private static final String HEADERS = "Headers";
	private static final String CONTENT_DATA = "ContentData";
	private static final String FTX_HEADER = "ContentType=application/jsonAccept=application/json;Content-Type=application/json;X-Requested-With=XmlHttpRequest";
	private static final String POST = "POST";
	private static final String TENANTID = "tenantid";
	private static final String VerifyOTP = "VerifyOTP v1.0.1";
	private static final String RESULTS_VALUE = "OTP";

	private static final Logger logger = LoggerFactory.getLogger(VerifyOTP.class);

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		printParams(workItem);

		WorkItemImpl customworkItem = new WorkItemImpl();
		String tenant_id = (String) workItem.getParameter(TENANT_ID);
		String user = (String) workItem.getParameter(USER);
		String token = (String) workItem.getParameter(TOKEN);
		

		try {

			getCustomWorkItem(workItem, customworkItem, getOTPBody(tenant_id, user, token));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		logger.error("executeWorkItem getParameters : " + customworkItem.getParameters());
		super.executeWorkItem(customworkItem, manager);
		logger.error("Results " + workItem.getId() + " : " + results);
		manager.completeWorkItem(workItem.getId(), results);

	}

	private void printParams(WorkItem workItem) {
		logger.error(logger.getName() + " Print all parameter");
		Map<String, Object> test = workItem.getParameters();

		for (Map.Entry<String, Object> entry : test.entrySet()) {
			logger.error(logger.getName() + ">>" + entry.getKey() + ": " + entry.getValue());
		}
	}

	private void getCustomWorkItem(WorkItem workItem, WorkItemImpl customworkItem, String jsonString) {
		Map<String, Object> orignalparams = workItem.getParameters();
		logger.error("executeWorkItem orignalparams : " + orignalparams);
		logger.error("executeWorkItem jsonString : " + jsonString);
		//customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, Config.getInstance().getPropValue(SERVER_USER));
		customworkItem.setParameter(Constants.LPASS, Config.getInstance().getPropValue(SERVER_PASSWORD));
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);
		customworkItem.setParameter(URL,
				Config.getInstance().getPropValue(SERVER) + Config.getInstance().getPropValue(API_OTP_VALIDATE));
		customworkItem.setParameter(METHOD, POST);
		customworkItem.setParameter(CONTENT_DATA, jsonString);
		customworkItem.setParameter(HEADERS, FTX_HEADER);
		printParams(customworkItem);
	}

	private String getOTPBody(String tenant_id, String user, String token) {
		return "{\"tenant\":\"" + tenant_id + "\",\"username\":\"" + user + "\",\"token\":\"" + token
				+ "\",\"locale\":\"en\"}";
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

		this.results = results;

	}

}

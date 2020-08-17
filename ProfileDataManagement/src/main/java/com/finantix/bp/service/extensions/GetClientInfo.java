package com.finantix.bp.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finantix.mdl.adbk.core.dto.ContactDTO;

import java.io.IOException;

import java.util.Map;

import org.drools.core.process.instance.impl.WorkItemImpl;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;

public class GetClientInfo extends RESTWorkItemHandler {

	private static final String CLIENTID = "clientid";
	private static final String serverURL = "/rest/adbk/contacts";
	String host = null;
	String user = null;
	String password = null;
	private static final String RESULTS_VALUE = "ClientInfo";
	private static final String METHOD = "Method";
	private static final String URL = "Url";
	private static final String CONTENT_TYPE = "ContentType";
	private static final String APPLICATION_JSON = "application/json";
	private static final String HEADERS = "Headers";
	private static final String CONTENT_DATA = "ContentData";
	private static final String FTX_HEADER = "ContentType=application/jsonAccept=application/json;Content-Type=application/json;X-Requested-With=XmlHttpRequest";
	private static final String GET = "GET";
	private static final String NUMBER = "number";
	private static final String ORG = "org";
	private static final String TENANTID = "tenantid";
	private static final String USEREMAIL = "useremail";
	private static final String PASSWORD = "password";
	private static final String USER = "user";
	private static final String SERVER = "server";
	private static final String GETCLIENTNFO = "FTX GetClientInfo v1.0.1";
	private static final Logger logger = LoggerFactory.getLogger(GetClientInfo.class);
	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		logger.error(GETCLIENTNFO);
		com.finantix.bp.service.extensions.Util util = new com.finantix.bp.service.extensions.Util();
		try {
			host = util.getPropValue(SERVER);
			user = util.getPropValue(USER);
			password = util.getPropValue(PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		logger.error("serverURL:" + serverURL);
		WorkItemImpl customworkItem = new WorkItemImpl();

		String clientid = (String) workItem.getParameter(CLIENTID);

		logger.error("executeWorkItem orignalparams clientid: " + clientid);

		if (clientid == null) {
			clientid = "-1";
		} else if (clientid.isEmpty())
			clientid = "-1";

		Map<String, Object> orignalparams = workItem.getParameters();

		customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, user);
		customworkItem.setParameter(Constants.LPASS, password);
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);
		customworkItem.setParameter(URL, host + serverURL + "/" + clientid);
		customworkItem.setParameter(METHOD, GET);

		customworkItem.setParameter(HEADERS, FTX_HEADER);

		logger.error("3 I executeWorkItem new getParameters: " + customworkItem.getParameters());

		super.executeWorkItem(customworkItem, manager);
		logger.error("6 I executeWorkItem   results: " + results);

		String jsonObject = (String) results.get("Result");
		ContactDTO contact = new ContactDTO();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		String jsonInputData = null;
		try {

			logger.error("executeWorkItem   jsonMap  : " + jsonMap);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			contact = objectMapper.readValue(jsonObject, ContactDTO.class);

			logger.error("executeWorkItem   contact  : " + contact.getBirthDate());
			logger.error("executeWorkItem   contact  : " + contact.getLastName());

			if (contact != null) {
				results.put(RESULTS_VALUE, contact);

			}

			logger.error("executeWorkItem   results  : " + results);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.error("completeWorkItem  for workItem.getId: " + workItem.getId());
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

		logger.error("4 postProcessResult  result: " + result);

		if (!StringUtils.isEmpty(resultClass) && !StringUtils.isEmpty(contentType)) {
			try {
				Class<?> clazz = Class.forName(resultClass, true, classLoader);

				logger.error("5 postProcessResult executeWorkItem  result: " + result + "clazz:" + clazz);

				Object resultObject = transformResult(clazz, contentType, result);

				results.put(PARAM_RESULT, resultObject);
			} catch (Throwable e) {
				throw new RuntimeException("Unable to transform respose to object", e);
			}
		} else {

			results.put(PARAM_RESULT, result);
		}
		logger.error("5 postProcessResult executeWorkItem  results: " + results);
		this.results = results;

	}

}

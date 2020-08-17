package com.finantix.bp.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finantix.mdl.adbk.core.dto.AddressDTO;
import com.finantix.mdl.adbk.core.dto.AddressesDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.process.workitem.rest.RESTServiceException;
import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;

public class UpdateClientAddresses extends RESTWorkItemHandler {

	private static final String UPDATE_CLIENT_ADDRESSES = "FTX UpdateClientAddresses v1.0.1";
	private static final String CLIENTID = "clientid";
	private static final String ADDRESSES_INFO = "addressesInfo";
	String serverURL = "/rest/adbk/contacts/";
	String host = null;
	String user = null;
	String password = null;

	private static final String METHOD = "Method";
	private static final String URL = "Url";
	private static final String CONTENT_TYPE = "ContentType";
	private static final String APPLICATION_JSON = "application/json";
	private static final String HEADERS = "Headers";
	private static final String CONTENT_DATA = "ContentData";
	private static final String FTX_HEADER = "ContentType=application/jsonAccept=application/json;Content-Type=application/json;X-Requested-With=XmlHttpRequest";
	private static final String PUT = "PUT";

	private static final String PASSWORD = "password";
	private static final String USER = "user";
	private static final String SERVER = "server";

	private static final Logger logger = LoggerFactory.getLogger(UpdateClientAddresses.class);

	private static final String RESULTS_VALUE = "clientAddress";

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		logger.error("");
		logger.error(UPDATE_CLIENT_ADDRESSES);
		logger.error("");
		WorkItemImpl customworkItem = new WorkItemImpl();

		com.finantix.bp.service.extensions.Util util = new com.finantix.bp.service.extensions.Util();
		try {
			host = util.getPropValue(SERVER);
			user = util.getPropValue(USER);
			password = util.getPropValue(PASSWORD);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		logger.error("serverURL:" + serverURL);

		AddressDTO addreses = (AddressDTO) workItem.getParameter(ADDRESSES_INFO);
		String clientid = (String) workItem.getParameter(CLIENTID);

		Map<String, Object> orignalparams = workItem.getParameters();
		logger.error("executeWorkItem orignalparams addreses: " + addreses);

		customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, user);
		customworkItem.setParameter(Constants.LPASS, password);
		customworkItem.setParameter(CONTENT_TYPE, APPLICATION_JSON);

		customworkItem.setParameter(METHOD, PUT);

		ObjectMapper mapper = new ObjectMapper();

		if (addreses != null) {

			try {
				customworkItem.setParameter(URL, host + serverURL + clientid + "/addresses");

				String jsonString = mapper.writeValueAsString(addreses);
				customworkItem.setParameter(CONTENT_DATA, jsonString);

				customworkItem.setParameter(HEADERS, FTX_HEADER);

				logger.error("executeWorkItem getParameters : " + customworkItem.getParameters());

				super.executeWorkItem(customworkItem, manager);
				logger.error("6 I executeWorkItem   results: " + results);

				results.put(RESULTS_VALUE, addreses);

				manager.completeWorkItem(workItem.getId(), results);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			logger.error("");
			logger.error(UPDATE_CLIENT_ADDRESSES);
			logger.error("");

		}

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

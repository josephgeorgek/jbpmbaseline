package com.finantix.bp.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finantix.mdl.adbk.core.dto.AddressDTO;
import com.finantix.mdl.adbk.core.dto.AddressesDTO;

import java.io.IOException;

import java.util.Map;

import org.drools.core.process.instance.impl.WorkItemImpl;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;

public class GetClientAddresses extends RESTWorkItemHandler {
	private static final String GET_CLIENT_ADDRESSES = "FTX GetClientAddresses v1.0.1";
	private static final String CLIENTID = "clientid";
	String serverURL = "/rest/adbk/contacts";
	String host = null;
	String User = null;
	String Password = null;
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
	private static final String RESULTS_VALUE = "clientAddress";
	private static final Logger logger = LoggerFactory.getLogger(GetClientAddresses.class);

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		String host = null;
		String user = null;
		String password = null;
		logger.error("");
		logger.error(GET_CLIENT_ADDRESSES);
		logger.error("");

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

		logger.error("1 executeWorkItem orignalparams clientid: " + clientid);

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
		customworkItem.setParameter(URL, host + serverURL + "/" + clientid + "/addresses");
		customworkItem.setParameter(METHOD, GET);
		customworkItem.setParameter(HEADERS, FTX_HEADER);

		logger.error("3 I executeWorkItem new getParameters: " + customworkItem.getParameters());

		super.executeWorkItem(customworkItem, manager);
		logger.error("6 I executeWorkItem   results: " + results);

		String jsonObject = (String) results.get("Result");
		logger.error("GetClientAddresses executeWorkItem   jsonObject: " + jsonObject);
		AddressDTO[] address;
		AddressesDTO addreses = new AddressesDTO();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		String jsonInputData = null;
		try {

			logger.error("GetClientAddresses executeWorkItem   jsonMap  : " + jsonMap);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			address = objectMapper.readValue(jsonObject, AddressDTO[].class);

			logger.error("GetClientAddresses executeWorkItem   contact  : " + addreses);
			if (address != null) {

				addreses.setAddresses(address);

				if (address.length > 0)
					results.put(RESULTS_VALUE, address[0]);

			}

			logger.error(GET_CLIENT_ADDRESSES + " GetClientAddresses executeWorkItem   results  : " + results);
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

		logger.error(GET_CLIENT_ADDRESSES + " completeWorkItem  for workItem.getId: " + workItem.getId());
		logger.error("");
		logger.error(GET_CLIENT_ADDRESSES);
		logger.error("");

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
		logger.error("5 postProcessResult executeWorkItem  results: " + results);
		this.results = results;

	}

}

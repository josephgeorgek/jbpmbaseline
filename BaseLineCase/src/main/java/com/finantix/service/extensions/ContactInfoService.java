package com.finantix.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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


public class ContactInfoService extends RESTWorkItemHandler {

	
	
	String host = null;
	String user = null;
	String password = null;
	

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		System.out.println("***");
		System.out.println("ContactInfoService v1.4.3");
		WorkItemImpl customworkItem = new WorkItemImpl();
		String jsonString = "";
		Map<String, Object> orignalparams = workItem.getParameters();
		System.out.println("ContactInfoService orignalparams : " + orignalparams);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		String jsonInputData = null;
		
		String contactId = String.valueOf( (Object) workItem.getParameter("contactId"));
		System.out.println("ContactInfoService contactId : " + contactId );
		
		
		try {
			host = Constants.SERVER;
			user = Constants.ADMIN;
			password = Constants.PASSWORD;
				
					
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	
		customworkItem.setParameters(orignalparams);
		customworkItem.setParameter(Constants.AUTH_TYPE, Constants.BASIC);
		customworkItem.setParameter(Constants.LOGIN, user);
		customworkItem.setParameter(Constants.LPASS, password);
		customworkItem.setParameter("ContentType", "application/json");
		//final String sURL = serverURL;
		customworkItem.setParameter("Url", host + Constants.CP_URL+"/"+contactId);
		
		
		customworkItem.setParameter("Method", Constants.HTTP_GET);
		
		customworkItem.setParameter("ContentData", jsonString);

		customworkItem.setParameter("Headers", Constants.HPARAMETERS);

		System.out.println("executeWorkItem getParameters : " + customworkItem.getParameters());

		super.executeWorkItem(customworkItem, manager);

		System.out.println("executeWorkItem   results  : " + results);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String jsonObject = (String) results.get("Result");
		
		/*ClientInfoDTO client = new ClientInfoDTO();

		try {
		
			
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			//client = objectMapper.readValue(jsonObject, ClientInfoDTO.class);
			System.out.println("executeWorkItem Result  contact  : " + client);
			System.out.println("executeWorkItem Result  id  : " + client.getId());

			if (client != null) {
				results.put(Constants.RESULTS_VALUE, client.getId());
				results.put("firstName", client.getName());
				results.put("lastName", client.getLastName());
				results.put("birthDate", client.getBirthDate());
				results.put("clientStatus", client.getClientStatus());
				
				if (client.getEmails()!= null)
					if (client.getEmails().size() > 0)
				results.put("email", client.getEmails().get(0).getEmail());
				if (client.getPhones() != null)
					if (client.getPhones().size() > 0)
				results.put("phone", client.getPhones().get(0).getNumber());
				if (client.getAddresses()  != null)
				if (client.getAddresses().size() > 0)
				results.put("domicile", client.getAddresses().get(0).getCountry());
				results.put("clientDTO", client);
			}
			
			else {
				results.put(Constants.RESULTS_VALUE, contactId);
				results.put("firstName", Constants.NOT_FOUND);
				results.put("lastName", Constants.NOT_FOUND);
				results.put("country", Constants.NOT_FOUND);
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}*/
		
		
		
		System.out.println("ContactInfoService completeWorkItem  for workItem.getId: " + workItem.getId()+">>results:"+results);
		System.out.println("***");
		System.out.println("***");
		manager.completeWorkItem(workItem.getId(), results);
		
		System.out.println("***");
		
		
		
		
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

		System.out.println("4 postProcessResult  result: " + result);

		if (!StringUtils.isEmpty(resultClass) && !StringUtils.isEmpty(contentType)) {
			try {
				Class<?> clazz = Class.forName(resultClass, true, classLoader);

				System.out.println("5 postProcessResult executeWorkItem  result: " + result + "clazz:" + clazz);

				Object resultObject = transformResult(clazz, contentType, result);

				results.put(PARAM_RESULT, resultObject);
			} catch (Throwable e) {
				throw new RuntimeException("Unable to transform respose to object", e);
			}
		} else {

			results.put(PARAM_RESULT, result);
		}
		System.out.println("5 postProcessResult executeWorkItem  results: " + results);
		this.results = results;

	}

	

}

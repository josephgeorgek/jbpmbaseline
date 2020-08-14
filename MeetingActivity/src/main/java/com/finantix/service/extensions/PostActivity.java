package com.finantix.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.finantix.service.extensions.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.process.workitem.rest.RESTServiceException;
import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostActivity extends RESTWorkItemHandler {
	
	 private static final Logger logger = LoggerFactory.getLogger(PostActivity.class);
	 
	private static final String APPLICATION_JSON = "application/json";

	private static final String ACTIVITY = "activity";

	private static final String MIXED = "mixed";

	private static final String REST_RS_ACTIVITYS = "/rest/rs/activitys";

	private static final String MULTIPART_MIXED_BOUNDARY_ACTIVITY = "multipart/mixed; boundary=activity-egdvve9pksq";

	private static final String POST_ACTIVITY = "PostActivity v1.4.0";

	
	String host = null;
	String user = null;
	String password = null;
	private static final String RESULTS_VALUE = "reviewid";

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		logger.error("***");
		logger.error(POST_ACTIVITY);

		WorkItemImpl customworkItem = new WorkItemImpl();
	
		String jsonString = "";
		Map<String, Object> orignalparams = workItem.getParameters();
		
		logger.error(POST_ACTIVITY+ "  orignalparams : " + orignalparams);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		String jsonInputData = null;
		try {
			host = Constants.SERVER;
			user = Constants.ADMIN;
			password = Constants.PASSWORD;
				
					
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		logger.error("executeWorkItem getParameters : " + workItem.getParameters());
		ObjectMapper mapper = new ObjectMapper();

		Object obj = workItem.getParameter("jsonString");
		logger.error("obj" + obj);
		LinkedHashMap myLinkedHashMap = null;
		
		try {
		LinkedHashMap myLinkedHashMap = (LinkedHashMap) obj;
		logger.error("myLinkedHashMap" + myLinkedHashMap);
		jsonString = new ObjectMapper().writeValueAsString(myLinkedHashMap);
		
		} 
		catch (Exception ex){
			//Map<String, String>  myLinkedHashMapmap = mapper.readValue(obj, Map.class);
			jsonString = String.valueOf(obj);
		}
		logger.error("jsonString" + jsonString);
	
		

		logger.error("executeWorkItem host : " + host + "  serverURL:" + REST_RS_ACTIVITYS +" jsonString  : " + jsonString);



		try {
			String outputResponse = sendBinary(host, REST_RS_ACTIVITYS, user, password, jsonString);

			if (outputResponse != null) {
				results.put(RESULTS_VALUE, outputResponse);
			}

			logger.error("executeWorkItem   results  : " + results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.error("sendBinary completeWorkItem  for workItem.getId: " + workItem.getId());
		logger.error("***");
		logger.error("***");
		manager.completeWorkItem(workItem.getId(), results);
	}

	private ClassLoader classLoader;

	Map<String, Object> results = new HashMap<String, Object>();

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



	public static String sendBinary(String host, String serverURL, String user, String password, String binarydata)
			throws Exception {
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(user, password);
		provider.setCredentials(AuthScope.ANY, credentials);

		HttpClient httpclient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

		HttpPost httppost = new HttpPost(host + serverURL);

		MultipartEntityBuilder entity2 = MultipartEntityBuilder.create().setMimeSubtype(MIXED)
				.addPart(FormBodyPartBuilder.create().setName(ACTIVITY)
						.setBody(new StringBody(binarydata, ContentType.create(APPLICATION_JSON))).build());

		httppost.setEntity(entity2.build());
		// httppost.setEntity(reqEntity.build());

		logger.error("executing request " + httppost.getRequestLine());

		HttpResponse response = httpclient.execute(httppost);
		String outputResponse;
		logger.error("1 ----------------------------------------");
		logger.error(response.getStatusLine().toString());
		logger.error("2 ----------------------------------------");
		outputResponse = EntityUtils.toString(response.getEntity());
		logger.error(outputResponse);
		logger.error("3 ----------------------------------------");

		HttpEntity resEntity = response.getEntity();

		if (resEntity != null) {
			logger.error("Response content length: " + resEntity.getContentLength());
		}

		return outputResponse;
	}
}

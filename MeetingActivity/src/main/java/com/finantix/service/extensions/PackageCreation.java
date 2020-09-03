package com.finantix.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.finantix.service.extensions.Constants;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.drools.core.process.instance.impl.WorkItemImpl;
import org.jbpm.process.workitem.rest.RESTServiceException;
import org.jbpm.process.workitem.rest.RESTWorkItemHandler;
import org.drools.core.util.StringUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.finantix.signer.core.dto.Location;
import com.finantix.signer.core.dto.PackageDTO;
import com.finantix.signer.core.dto.PackageDocDTO;
import com.finantix.signer.core.dto.PackageDocsLocDTO;
import com.finantix.signer.core.dto.PackageProcessedDTO;
import com.finantix.signer.core.dto.Signer;
import com.finantix.signer.core.dto.Stakeholder;

public class PackageCreation extends RESTWorkItemHandler {

	private static final Logger logger = LoggerFactory.getLogger(PackageCreation.class);

	private static final String APPLICATION_JSON = "application/json";

	private static final String ACTIVITY = "activity";

	private static final String MIXED = "mixed";

	
	private static final String MULTIPART_MIXED_BOUNDARY_ACTIVITY = "multipart/mixed; boundary=activity-egdvve9pksq";

	private static final String SIGN_ACTIVITY = "PackageCreation v1.4.0";

	String host = null;
	String user = null;
	String password = null;
	private static final String RESULTS_VALUE = "packageId";
	private static final String RESULTS_DOC_VALUE = "documentId";

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		logger.error("***");
		logger.error(SIGN_ACTIVITY);

		WorkItemImpl customworkItem = new WorkItemImpl();

		String jsonString = "";
		Map<String, Object> orignalparams = workItem.getParameters();
		
	

		logger.error(SIGN_ACTIVITY + "  orignalparams : " + orignalparams);

		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> jsonMap = null;
		String jsonInputData = null;
		try {
			host = Constants.SIGN_SERVER;
			user = Constants.SIGN_SERVER_LOGIN;
			password = Constants.SIGN_SERVER_LPASS;

			logger.error("executeWorkItem getParameters : " + workItem.getParameters());
			logger.error(SIGN_ACTIVITY + " getProcessInstanceId:"+ workItem.getProcessInstanceId());
		
			
			String packageName = String.valueOf((Object) workItem.getParameter("docName"));
			boolean single = Boolean.valueOf((String) workItem.getParameter("single"));
	//		java.util.List requiredDocuments = new java.util.ArrayList();
			java.util.List  requiredDocuments = (java.util.List) workItem.getParameter("parties");
			logger.error(" requiredDocuments : " + requiredDocuments);
			logger.error(" requiredDocuments : " + requiredDocuments.size());
			String pageNumber = "5";
			
			String docURL = Constants.docURL;
			
			results = 		processDoc( packageName, docURL, pageNumber,String.valueOf(workItem.getProcessInstanceId()), requiredDocuments );
	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		logger.error(SIGN_ACTIVITY + " executeWorkItem   results  : " + results);
		logger.error(SIGN_ACTIVITY + " completeWorkItem  for workItem.getId: " + workItem.getId());
		logger.error("***");
		logger.error("***");
		manager.completeWorkItem(workItem.getId(), results);
	}
	
	public static void main(String[] arg) {

		String initiator = "joseph.george@finantix.com";
		String fullName = "Joseph George";
		String email = "josephgeorgek@gmail.com";// "joseph.george@finantix.com";
		String phone = "+6591052920";
		String packageName = "Document  for " + fullName;
		String docURL = "https://srv-file14.gofile.io/download/S07CqW/eBANKING_SERVICES_AND_TERMS_AND_CONDITIONS_OF_USE.pdf";//"https://file-examples-com.github.io/uploads/2017/10/file-sample_150kB.pdf";// "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
		String pageNumber = "5";
		boolean single = false;
		Signer primary = new Signer();
		primary.setFirstName("Paul");
		primary.setLastName("Williams");
		primary.setEmail("joseph.george@finantix.com");
		primary.setPhone("+6591052920");
		
		Signer secondary = new Signer();
		secondary.setFirstName("John");
		secondary.setLastName("Smith");
		secondary.setEmail("josephgsgibmcom@gmail.com");
		secondary.setPhone("+6591052920");
		
		

		java.util.List parties = new java.util.ArrayList();
		parties.add(primary);
		parties.add(secondary);
		
		
		processDoc( packageName, docURL, pageNumber,pageNumber, parties );

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

	public static String get(String apiPath, String json) {
		String responseString = null;

		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet httpPost = new HttpGet(Constants.SIGN_SERVER + apiPath);
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(Constants.SIGN_SERVER_LOGIN,
					Constants.SIGN_SERVER_LPASS);
			httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

			StringEntity entity = new StringEntity(json);

			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println(responseString);
			logger.error(Constants.SIGN_SERVER + apiPath + " Post ProcessResult executeWorkItem  results: "
					+ response.getStatusLine().getStatusCode());

			client.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return responseString;

	}

	public static String put(String apiPath, String json) {
		String responseString = null;

		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPut httpPost = new HttpPut(Constants.SIGN_SERVER + apiPath);
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(Constants.SIGN_SERVER_LOGIN,
					Constants.SIGN_SERVER_LPASS);
			httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

			StringEntity entity = new StringEntity(json);

			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println(responseString);
			logger.error(Constants.SIGN_SERVER + apiPath + " Post ProcessResult executeWorkItem  results: "
					+ response.getStatusLine().getStatusCode());

			client.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return responseString;

	}

	public static String post(String apiPath, String json) {
		String responseString = null;

		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(Constants.SIGN_SERVER + apiPath);
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(Constants.SIGN_SERVER_LOGIN,
					Constants.SIGN_SERVER_LPASS);
			httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

			StringEntity entity = new StringEntity(json);

			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");

			CloseableHttpResponse response = client.execute(httpPost);
			HttpEntity responseEntity = response.getEntity();
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
			System.out.println(responseString);
			logger.error(Constants.SIGN_SERVER + apiPath + " Post ProcessResult executeWorkItem  results: "
					+ response.getStatusLine().getStatusCode());

			client.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return responseString;

	}

	

	public static Map processDoc(String packageName,
			String docURL, String pageNumber, String processid, java.util.List signers) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		String  initiator = "joseph.george@finantix.com";
		Map<String, Object> results = new HashMap<String, Object>();
		String apiPath = "packages";
		String jsonString = "{\n" + "  \"PackageName\": \" " + packageName + " \",\n" + "  \"Initiator\": \""
				+ initiator + "\",\n" + "  \"DocumentGroupCode\": \"00001\",\n"
				+ "  \"ExternalPackageReference\": \"  "+ processid+"   \"\n" + "}\n" + "";

		logger.error("executeWorkItem   jsonString  : " + jsonString);
	

		try {
			String outputResponse = post(apiPath, jsonString);
			
			logger.error("executeWorkItem   packageDocDTO outputResponse : " + outputResponse);
			com.finantix.signer.core.dto.PackageDTO packageDTO = new com.finantix.signer.core.dto.PackageDTO();
			packageDTO = objectMapper.readValue(outputResponse, PackageDTO.class);
			apiPath = "packages/" + packageDTO.getPackageId() + "/documents";
			logger.error("executeWorkItem   apiPath  : " + apiPath);

			String doc =  getDoc(docURL);
			
			
			jsonString = "{\n" + "  \"Document\":\"" + doc + "\", \"DocumentName\" : \"" + packageName + "\",\n"
					+ "  \"DocumentLanguage\" : \"en\",\n"
					+ "  \"ExternalDocumentReference\" : \"INV-2019-04-01-0039\",\n" + "  \"SigningFields\" : [\n"
					+ "  { \n" + "  	\"PageNumber\" : " + pageNumber + ",\n" + "  	\"Width\" : \"150\",\n"
					+ "  	\"Height\" : \"70\",\n" + "  	\"Left\" : \"220\",\n" + "  	\"Top\" : \"470\",\n"
					+ "  	\"Label\" : \"ThisIdentifiesJGSignature\"\n" + "  }" ;
			
			if (signers.size()> 1) {
				
				jsonString = jsonString
					+ "  ,{\n" + "  	\"PageNumber\" : " + pageNumber + ",\n" + "  	\"Width\" : \"150\",\n"
					+ "  	\"Height\" : \"70\",\n" + "  	\"Left\" : \"390\",\n" + "  	\"Top\" : \"470\",\n"
					+ "  	\"Label\" : \"ThisIdentifiesJGSignature2\"\n" + "  }\n" ;
			}; 
			
			jsonString = jsonString	+ " ]}";

		//	logger.error("executeWorkItem   jsonString  : " + jsonString);
			logger.error("executeWorkItem   ***** " );

			outputResponse = post(apiPath, jsonString);

			com.finantix.signer.core.dto.PackageDocDTO packageDocDTO = new com.finantix.signer.core.dto.PackageDocDTO();
			packageDocDTO = objectMapper.readValue(outputResponse, PackageDocDTO.class);

			logger.error("executeWorkItem   packageDocDTO  : " + packageDTO);
			logger.error("executeWorkItem   packageDocDTO  : " + packageDTO.getPackageId());

			if (packageDocDTO != null) {
				results.put(RESULTS_VALUE, packageDTO.getPackageId());
			}
			
			logger.error("locations   packageDocDTO  : " + packageDocDTO);
			logger.error("locations   packageDocDTO getDocumentId  : " + packageDocDTO.getDocumentId());
			logger.error("locations   packageDocDTO getLocations  : " + packageDocDTO.getLocations().size());
			
			
	
			jsonString = " \n" + "  {\n" + "\"Stakeholders\": [\n" + " ";
			int i = 0;
			for (Location loc : packageDocDTO.getLocations())
					{
						
						
Signer reqDoc =	(Signer)signers.get(i);
						if(i != 0)jsonString =	jsonString	+ ", ";
						jsonString =	jsonString	+ "   {\n" + "     \"FirstName\": \"eSig: \",\n"
								+ "      \"LastName\": \"" + reqDoc.getFirstName() +" "+reqDoc.getLastName() + "\",\n" + "      \"EmailAddress\": \"" + reqDoc.getEmail() + "\",\n"
								+ "      \"Language\": \"en\",\n" + "      \"BirthDate\": \"1982-09-24\",\n"
								+ "      \"ExternalStakeholderReference\": \""+reqDoc.getEmail()+"  \",\n" + "      \"Actors\": [\n"
								+ "        {\n" + "          \"Type\": \"Signer\",\n" + "          \"OrderIndex\": 1,\n"
								+ "          \"LocationIds\": [\n" + "            \"    " + loc.getId() + "      \"\n" + "          ],\n"
								+ "          \"SigningTypes\": [\n" + "            {\n"
								+ "              \"SigningType\": \"MailOtp\",\n"
								+ "              \"MandatedSignerValidation\": \"MatchId\",\n"
								+ "              \"MandatedSignerIds\": [\n" + "                \"72092400465\", \"72092630155\"\n"
								+ "              ]\n" + "            }\n" + "          ],\n" + "          \"PhoneNumber\": \" "
								+ reqDoc.getPhone() + " \",\n" + "          \"UserRoles\": [\n" + "            \"Lawyer\"\n" + "          ],\n"
								+ "          \"SendNotifications\": true,\n"
								+ "          \"RedirectUrl\": \" "+ Constants.SERVER_BP+processid+"   \"\n"
								+ "        }\n" + "      ]\n" + "    }\n" + " ";
					i++;
					}
					
					
					
					
					
					jsonString =	jsonString			+ " ]\n" + "}";
					logger.error("process   ******  : "  );
					logger.error("process   ******  : "  );
					logger.error("process   jsonString  : " + jsonString);
					logger.error("process   ******  : "  );
					logger.error("process   ******  : "  );
					
					apiPath = "packages/" + packageDTO.getPackageId() + "/process";
			logger.error("process   apiPath  : " + apiPath);
			
			
			outputResponse = put(apiPath, jsonString);
			logger.error("process   outputResponse  : " + outputResponse);
			
			
			apiPath = "packages/" + packageDTO.getPackageId() + "/status?Status=Pending";

			logger.error("executeWorkItem   apiPath  : " + apiPath);
			jsonString = "{\n" + "   \"Status\": \"Pending\"\n" + "}";
			outputResponse = put(apiPath, jsonString);

			com.finantix.signer.core.dto.PackageProcessedDTO packageProcessedDTO = new com.finantix.signer.core.dto.PackageProcessedDTO();
			packageProcessedDTO = objectMapper.readValue(outputResponse, PackageProcessedDTO.class);

			logger.error("executeWorkItem   packageProcessedDTO  : " + packageProcessedDTO);
			logger.error("executeWorkItem   packageProcessedDTO  : " + packageProcessedDTO.getF2FSigningUrl());
			logger.error("executeWorkItem   packageProcessedDTO  : " + packageProcessedDTO.getStakeholders());
			String signURL = (String) packageProcessedDTO.getStakeholders().get(0).getActors().get(0).getActionUrl();
			String packageURL = Constants.SIGN_SERVER + "packages/" + packageDTO.getPackageId() + "/download";
			
			logger.error("executeWorkItem   signURL  : " + signURL);
			logger.error("executeWorkItem   packageURL  : " + packageURL);
		
			java.util.List signURLs = new java.util.ArrayList();
			for (Stakeholder  stakeholder : packageProcessedDTO.getStakeholders()) {
				signURLs.add(stakeholder.getActors().get(0).getActionUrl()+"?email="+stakeholder.getEmailAddress());
				
			}
			if (signURL != null) {
				results.put(RESULTS_VALUE, signURLs);
				

			}
			results.put(RESULTS_DOC_VALUE, packageURL);
			
			
			logger.error("executeWorkItem   results  : " + results);

			logger.error("executeWorkItem   results  : " + results);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return results;
	}

	private static String getDoc(String url) {

		try {
			URL imageUrl = new URL(url);
			URLConnection ucon = imageUrl.openConnection();
			InputStream is = ucon.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int read = 0;
			while ((read = is.read(buffer, 0, buffer.length)) != -1) {
				baos.write(buffer, 0, read);
			}
			baos.flush();
			Base64 base64 = new Base64();
			return new String(base64.encode(baos.toByteArray()));
		
		} catch (Exception e) {
			logger.error("Error", e.toString());
		}
		return null;
	}
}

package com.finantix.bp.service.extensions;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import org.jbpm.process.workitem.rest.RESTWorkItemHandler;


public class VerifyOTP extends RESTWorkItemHandler {
	private static final String VERIFY_OTP = "VerifyOTP v1.3.8";

	private static final Logger logger = LoggerFactory.getLogger(VerifyOTP.class);

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		logger.error(VERIFY_OTP);

		manager.completeWorkItem(workItem.getId(), results);
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		super.abortWorkItem(workItem, manager);
	}

	private ClassLoader classLoader;

	Map<String, Object> results = null;

}

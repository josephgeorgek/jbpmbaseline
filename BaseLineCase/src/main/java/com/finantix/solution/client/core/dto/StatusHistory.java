
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.Map;

public class StatusHistory {

    private String clientAdvisor;
    private String date;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getClientAdvisor() {
        return clientAdvisor;
    }

    public void setClientAdvisor(String clientAdvisor) {
        this.clientAdvisor = clientAdvisor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

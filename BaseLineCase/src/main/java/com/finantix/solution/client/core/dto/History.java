
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class History {

    private Integer questionnaireId;
    private String riskProfileId;
    private String status;
    private List<StatusHistory> statusHistory = null;
    private String effectiveFrom;
    private String endDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getRiskProfileId() {
        return riskProfileId;
    }

    public void setRiskProfileId(String riskProfileId) {
        this.riskProfileId = riskProfileId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StatusHistory> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<StatusHistory> statusHistory) {
        this.statusHistory = statusHistory;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

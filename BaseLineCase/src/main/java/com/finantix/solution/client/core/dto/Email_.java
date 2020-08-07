
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.Map;

public class Email_ {

    private String email;
    private Integer emailId;
    private String emailType;
    private Integer id;
    private Integer linkedEmailId;
    private String namedCommonId;
    private Integer numberedCommonId;
    private Boolean preferred;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkedEmailId() {
        return linkedEmailId;
    }

    public void setLinkedEmailId(Integer linkedEmailId) {
        this.linkedEmailId = linkedEmailId;
    }

    public String getNamedCommonId() {
        return namedCommonId;
    }

    public void setNamedCommonId(String namedCommonId) {
        this.namedCommonId = namedCommonId;
    }

    public Integer getNumberedCommonId() {
        return numberedCommonId;
    }

    public void setNumberedCommonId(Integer numberedCommonId) {
        this.numberedCommonId = numberedCommonId;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

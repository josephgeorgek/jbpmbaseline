
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.Map;

public class Phone_ {

    private String countryCode;
    private Integer id;
    private Integer linkedPhoneId;
    private String number;
    private Integer phoneId;
    private String phoneType;
    private Boolean preferred;
    private String validFrom;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkedPhoneId() {
        return linkedPhoneId;
    }

    public void setLinkedPhoneId(Integer linkedPhoneId) {
        this.linkedPhoneId = linkedPhoneId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

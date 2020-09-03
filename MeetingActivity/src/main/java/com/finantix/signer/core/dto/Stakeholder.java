
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stakeholder {

    private String type;
    private String emailAddress;
    private Object contactGroupCode;
    private String externalStakeholderReference;
    private String stakeholderId;
    private List<Actor> actors = null;
    private Object personGroupName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Object getContactGroupCode() {
        return contactGroupCode;
    }

    public void setContactGroupCode(Object contactGroupCode) {
        this.contactGroupCode = contactGroupCode;
    }

    public String getExternalStakeholderReference() {
        return externalStakeholderReference;
    }

    public void setExternalStakeholderReference(String externalStakeholderReference) {
        this.externalStakeholderReference = externalStakeholderReference;
    }

    public String getStakeholderId() {
        return stakeholderId;
    }

    public void setStakeholderId(String stakeholderId) {
        this.stakeholderId = stakeholderId;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Object getPersonGroupName() {
        return personGroupName;
    }

    public void setPersonGroupName(Object personGroupName) {
        this.personGroupName = personGroupName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

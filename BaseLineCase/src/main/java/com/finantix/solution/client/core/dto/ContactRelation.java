
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactRelation {

    private String adbkRelationSubType;
    private String adbkRelationType;
    private List<Address_> addresses = null;
    private Integer applicationId;
    private String bpNumber;
    private String bpRelationshipType;
    private String clientStatus;
    private String clientType;
    private Boolean draft;
    private List<Email> emails = null;
    private Integer id;
    private String name;
    private String ownership;
    private Boolean personal;
    private List<Phone> phones = null;
    private String relatedNamedCommonId;
    private Integer relatedNumberedCommonId;
    private Boolean relatedTarget;
    private Integer relationId;
    private String relationType;
    private Integer sourceContactId;
    private String sourceNamedCommonId;
    private Integer sourceNumberedCommonId;
    private Integer targetContactId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAdbkRelationSubType() {
        return adbkRelationSubType;
    }

    public void setAdbkRelationSubType(String adbkRelationSubType) {
        this.adbkRelationSubType = adbkRelationSubType;
    }

    public String getAdbkRelationType() {
        return adbkRelationType;
    }

    public void setAdbkRelationType(String adbkRelationType) {
        this.adbkRelationType = adbkRelationType;
    }

    public List<Address_> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address_> addresses) {
        this.addresses = addresses;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getBpNumber() {
        return bpNumber;
    }

    public void setBpNumber(String bpNumber) {
        this.bpNumber = bpNumber;
    }

    public String getBpRelationshipType() {
        return bpRelationshipType;
    }

    public void setBpRelationshipType(String bpRelationshipType) {
        this.bpRelationshipType = bpRelationshipType;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public Boolean getPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getRelatedNamedCommonId() {
        return relatedNamedCommonId;
    }

    public void setRelatedNamedCommonId(String relatedNamedCommonId) {
        this.relatedNamedCommonId = relatedNamedCommonId;
    }

    public Integer getRelatedNumberedCommonId() {
        return relatedNumberedCommonId;
    }

    public void setRelatedNumberedCommonId(Integer relatedNumberedCommonId) {
        this.relatedNumberedCommonId = relatedNumberedCommonId;
    }

    public Boolean getRelatedTarget() {
        return relatedTarget;
    }

    public void setRelatedTarget(Boolean relatedTarget) {
        this.relatedTarget = relatedTarget;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public Integer getSourceContactId() {
        return sourceContactId;
    }

    public void setSourceContactId(Integer sourceContactId) {
        this.sourceContactId = sourceContactId;
    }

    public String getSourceNamedCommonId() {
        return sourceNamedCommonId;
    }

    public void setSourceNamedCommonId(String sourceNamedCommonId) {
        this.sourceNamedCommonId = sourceNamedCommonId;
    }

    public Integer getSourceNumberedCommonId() {
        return sourceNumberedCommonId;
    }

    public void setSourceNumberedCommonId(Integer sourceNumberedCommonId) {
        this.sourceNumberedCommonId = sourceNumberedCommonId;
    }

    public Integer getTargetContactId() {
        return targetContactId;
    }

    public void setTargetContactId(Integer targetContactId) {
        this.targetContactId = targetContactId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

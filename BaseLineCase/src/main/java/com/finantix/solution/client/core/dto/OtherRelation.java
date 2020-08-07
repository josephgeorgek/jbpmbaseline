
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OtherRelation {

    private String adbkRelationSubType;
    private String adbkRelationType;
    private List<Object> addresses = null;
    private Integer applicationId;
    private String birthDate;
    private String clientStatus;
    private String clientType;
    private Boolean draft;
    private List<Object> emails = null;
    private String gender;
    private Integer id;
    private String name;
    private String ownership;
    private Boolean personal;
    private List<Object> phones = null;
    private String relatedNamedCommonId;
    private Integer relatedNumberedCommonId;
    private Boolean relatedTarget;
    private Integer relationId;
    private String relationType;
    private List<SourceAddress> sourceAddresses = null;
    private Integer sourceContactId;
    private List<SourceEmail> sourceEmails = null;
    private String sourceNamedCommonId;
    private Integer sourceNumberedCommonId;
    private List<SourcePhone> sourcePhones = null;
    private List<TargetAddress> targetAddresses = null;
    private Integer targetContactId;
    private List<Object> targetEmails = null;
    private List<Object> targetPhones = null;
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

    public List<Object> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Object> addresses) {
        this.addresses = addresses;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public List<Object> getEmails() {
        return emails;
    }

    public void setEmails(List<Object> emails) {
        this.emails = emails;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<Object> getPhones() {
        return phones;
    }

    public void setPhones(List<Object> phones) {
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

    public List<SourceAddress> getSourceAddresses() {
        return sourceAddresses;
    }

    public void setSourceAddresses(List<SourceAddress> sourceAddresses) {
        this.sourceAddresses = sourceAddresses;
    }

    public Integer getSourceContactId() {
        return sourceContactId;
    }

    public void setSourceContactId(Integer sourceContactId) {
        this.sourceContactId = sourceContactId;
    }

    public List<SourceEmail> getSourceEmails() {
        return sourceEmails;
    }

    public void setSourceEmails(List<SourceEmail> sourceEmails) {
        this.sourceEmails = sourceEmails;
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

    public List<SourcePhone> getSourcePhones() {
        return sourcePhones;
    }

    public void setSourcePhones(List<SourcePhone> sourcePhones) {
        this.sourcePhones = sourcePhones;
    }

    public List<TargetAddress> getTargetAddresses() {
        return targetAddresses;
    }

    public void setTargetAddresses(List<TargetAddress> targetAddresses) {
        this.targetAddresses = targetAddresses;
    }

    public Integer getTargetContactId() {
        return targetContactId;
    }

    public void setTargetContactId(Integer targetContactId) {
        this.targetContactId = targetContactId;
    }

    public List<Object> getTargetEmails() {
        return targetEmails;
    }

    public void setTargetEmails(List<Object> targetEmails) {
        this.targetEmails = targetEmails;
    }

    public List<Object> getTargetPhones() {
        return targetPhones;
    }

    public void setTargetPhones(List<Object> targetPhones) {
        this.targetPhones = targetPhones;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

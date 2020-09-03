
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageProcessedDTO {

    private String packageName;
    private String documentGroupCode;
    private String initiator;
    private Object expiryTimestamp;
    private String externalPackageReference;
    private String f2FSigningUrl;
    private String packageStatus;
    private List<PackageDocument> packageDocuments = null;
    private List<Stakeholder> stakeholders = null;
    private String creationTimestamp;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDocumentGroupCode() {
        return documentGroupCode;
    }

    public void setDocumentGroupCode(String documentGroupCode) {
        this.documentGroupCode = documentGroupCode;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Object getExpiryTimestamp() {
        return expiryTimestamp;
    }

    public void setExpiryTimestamp(Object expiryTimestamp) {
        this.expiryTimestamp = expiryTimestamp;
    }

    public String getExternalPackageReference() {
        return externalPackageReference;
    }

    public void setExternalPackageReference(String externalPackageReference) {
        this.externalPackageReference = externalPackageReference;
    }

    public String getF2FSigningUrl() {
        return f2FSigningUrl;
    }

    public void setF2FSigningUrl(String f2FSigningUrl) {
        this.f2FSigningUrl = f2FSigningUrl;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public List<PackageDocument> getPackageDocuments() {
        return packageDocuments;
    }

    public void setPackageDocuments(List<PackageDocument> packageDocuments) {
        this.packageDocuments = packageDocuments;
    }

    public List<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(List<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

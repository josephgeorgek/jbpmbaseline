
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.Map;

public class PackageDocument {

    private String documentId;
    private String documentType;
    private String externalDocumentReference;
    private String documentName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getExternalDocumentReference() {
        return externalDocumentReference;
    }

    public void setExternalDocumentReference(String externalDocumentReference) {
        this.externalDocumentReference = externalDocumentReference;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

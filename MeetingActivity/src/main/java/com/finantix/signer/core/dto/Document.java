
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {

    private String documentId;
    private String externalDocumentReference;
    private List<Location> locations = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getExternalDocumentReference() {
        return externalDocumentReference;
    }

    public void setExternalDocumentReference(String externalDocumentReference) {
        this.externalDocumentReference = externalDocumentReference;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

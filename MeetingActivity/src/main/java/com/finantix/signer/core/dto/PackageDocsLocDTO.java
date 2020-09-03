
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackageDocsLocDTO {

    private List<Document> documents = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

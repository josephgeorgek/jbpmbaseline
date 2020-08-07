
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalContactRelation {

    private List<Object> familyRelations = null;
    private List<OtherRelation> otherRelations = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Object> getFamilyRelations() {
        return familyRelations;
    }

    public void setFamilyRelations(List<Object> familyRelations) {
        this.familyRelations = familyRelations;
    }

    public List<OtherRelation> getOtherRelations() {
        return otherRelations;
    }

    public void setOtherRelations(List<OtherRelation> otherRelations) {
        this.otherRelations = otherRelations;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

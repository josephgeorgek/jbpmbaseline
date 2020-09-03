
package com.finantix.signer.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actor {

    private String type;
    private Object reason;
    private Object completedBy;
    private Object completedTimestamp;
    private List<Location> locations = null;
    private String actorId;
    private Object actionUrl;
    private List<Object> actionUrls = null;
    private String actorStatus;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getReason() {
        return reason;
    }

    public void setReason(Object reason) {
        this.reason = reason;
    }

    public Object getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(Object completedBy) {
        this.completedBy = completedBy;
    }

    public Object getCompletedTimestamp() {
        return completedTimestamp;
    }

    public void setCompletedTimestamp(Object completedTimestamp) {
        this.completedTimestamp = completedTimestamp;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public Object getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(Object actionUrl) {
        this.actionUrl = actionUrl;
    }

    public List<Object> getActionUrls() {
        return actionUrls;
    }

    public void setActionUrls(List<Object> actionUrls) {
        this.actionUrls = actionUrls;
    }

    public String getActorStatus() {
        return actorStatus;
    }

    public void setActorStatus(String actorStatus) {
        this.actorStatus = actorStatus;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

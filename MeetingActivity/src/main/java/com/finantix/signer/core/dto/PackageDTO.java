
package com.finantix.signer.core.dto;



public class PackageDTO {

  //  private String PackageId;
    private String packageId;
    private String creationTimestamp;
   // private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    /*
     * 
    public String getPackageId() {
        return PackageId;
    }

    public void setPackageId(String PackageId) {
        this.PackageId = PackageId;
    }

     public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }*/

}

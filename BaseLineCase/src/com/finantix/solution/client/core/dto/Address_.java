
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.Map;

public class Address_ {

    private Integer addressId;
    private String area;
    private String careOf;
    private String city;
    private String correspondenceLanguage;
    private String country;
    private Integer id;
    private Integer linkedAddressId;
    private String name;
    private String namedCommonId;
    private String note;
    private Integer numberedCommonId;
    private String postalCode;
    private Boolean preferred;
    private String street;
    private String validFrom;
    private String validTo;
    private String houseNumber;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCorrespondenceLanguage() {
        return correspondenceLanguage;
    }

    public void setCorrespondenceLanguage(String correspondenceLanguage) {
        this.correspondenceLanguage = correspondenceLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkedAddressId() {
        return linkedAddressId;
    }

    public void setLinkedAddressId(Integer linkedAddressId) {
        this.linkedAddressId = linkedAddressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamedCommonId() {
        return namedCommonId;
    }

    public void setNamedCommonId(String namedCommonId) {
        this.namedCommonId = namedCommonId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getNumberedCommonId() {
        return numberedCommonId;
    }

    public void setNumberedCommonId(Integer numberedCommonId) {
        this.numberedCommonId = numberedCommonId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

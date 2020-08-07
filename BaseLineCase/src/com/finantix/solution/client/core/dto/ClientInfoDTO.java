
package com.finantix.solution.client.core.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientInfoDTO {

    private List<Address> addresses = null;
    private List<String> advisorRoles = null;
    private String amlHigherRisk;
    private String amlHigherRiskComment;
    private String amlHigherRiskElement1;
    private String amlHigherRiskElement2;
    private String amlHigherRiskElement3;
    private String assistantName;
    private String baseEntityType;
    private String birthDate;
    private String calculatedRiskCategory;
    private String cityOfBirth;
    private String clientAdvisor;
    private Integer clientId;
    private String clientStatus;
    private String clientType;
    private List<Object> communications = null;
    private Integer contactId;
    private List<ContactRelation> contactRelations = null;
    private String contactRestrictions;
    private String countryOfBirthId;
    private String createdBy;
    private String createdOn;
    private List<Document> documents = null;
    private String doubleTaxTreaty;
    private List<Email_> emails = null;
    private Integer expectedInvestmentAmount;
    private String expectedInvestmentCurrency;
    private String fatcaClassification;
    private String financialAversions;
    private List<Object> financialInterests = null;
    private String gender;
    private List<Object> gifts = null;
    private String goals;
    private List<Object> groupRelations = null;
    private List<Object> hobbies = null;
    private Integer id;
    private String idDocumentExpiryDate;
    private String idDocumentNationality;
    private String incomeReferenceYear;
    private String incomeType;
    private List<Object> industryActivities = null;
    private String jointAccountTreatment;
    private List<Object> jurisdictions = null;
    private String lastName;
    private String legalAndTaxAdvisor;
    private String manualRiskCategory;
    private String maritalStatus;
    private String modifiedBy;
    private String modifiedOn;
    private String name;
    private String namedCommonId;
    private String nationalIdentificationCode;
    private String nationality;
    private List<Note> notes = null;
    private Integer numberedCommonId;
    private String openingDate;
    private List<Integer> opportunities = null;
    private List<Object> otherChannels = null;
    private String otherFinancialAdvisor;
    private List<Object> otherNationalities = null;
    private List<String> otherTaxResidencies = null;
    private Integer overallEstimatedFinancialAssets;
    private String overallEstimatedFinancialAssetsCurrency;
    private Integer overallEstimatedNonFinancialAssets;
    private String overallEstimatedNonFinancialAssetsCurrency;
    private List<Object> partyRoles = null;
    private String pep;
    private String pepComment;
    private String pepElement;
    private Boolean personKnownToBanker;
    private PersonalContactRelation personalContactRelation;
    private List<Phone_> phones = null;
    private String pictureURN;
    private String potential;
    private String preferredComunicationChannel;
    private String preferredIndustries;
    private String preferredInstrumentArea;
    private String preferredLanguage;
    private String preferredMarkets;
    private PreviousAssignment previousAssignment;
    private List<String> profession = null;
    private Integer referralIncome;
    private String referralIncomeCurrency;
    private String referralType;
    private List<Object> reports = null;
    private String riskLevel;
    private List<Object> riskProfileHistories = null;
    private String smartKYCReviewId;
    private String sourceOfWealth;
    private Suitability suitability;
    private String summary;
    private String taxRegionId;
    private List<Object> taxes = null;
    private Integer updateVersion;
    private String usAssetsAccountHolderTrade;
    private String usAssetsTradeAllowed;
    private String usBorn;
    private String usCitizen;
    private String usGreenCardHolder;
    private Boolean usIndiciaFound;
    private String usPresenceTest;
    private String usTaxPayer;
    private String wealthCategory;
    private List<String> wealthCreationCountries = null;
    private String wealthCurrentStage;
    private String wealthStructureAllocation;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getAdvisorRoles() {
        return advisorRoles;
    }

    public void setAdvisorRoles(List<String> advisorRoles) {
        this.advisorRoles = advisorRoles;
    }

    public String getAmlHigherRisk() {
        return amlHigherRisk;
    }

    public void setAmlHigherRisk(String amlHigherRisk) {
        this.amlHigherRisk = amlHigherRisk;
    }

    public String getAmlHigherRiskComment() {
        return amlHigherRiskComment;
    }

    public void setAmlHigherRiskComment(String amlHigherRiskComment) {
        this.amlHigherRiskComment = amlHigherRiskComment;
    }

    public String getAmlHigherRiskElement1() {
        return amlHigherRiskElement1;
    }

    public void setAmlHigherRiskElement1(String amlHigherRiskElement1) {
        this.amlHigherRiskElement1 = amlHigherRiskElement1;
    }

    public String getAmlHigherRiskElement2() {
        return amlHigherRiskElement2;
    }

    public void setAmlHigherRiskElement2(String amlHigherRiskElement2) {
        this.amlHigherRiskElement2 = amlHigherRiskElement2;
    }

    public String getAmlHigherRiskElement3() {
        return amlHigherRiskElement3;
    }

    public void setAmlHigherRiskElement3(String amlHigherRiskElement3) {
        this.amlHigherRiskElement3 = amlHigherRiskElement3;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getBaseEntityType() {
        return baseEntityType;
    }

    public void setBaseEntityType(String baseEntityType) {
        this.baseEntityType = baseEntityType;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCalculatedRiskCategory() {
        return calculatedRiskCategory;
    }

    public void setCalculatedRiskCategory(String calculatedRiskCategory) {
        this.calculatedRiskCategory = calculatedRiskCategory;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public String getClientAdvisor() {
        return clientAdvisor;
    }

    public void setClientAdvisor(String clientAdvisor) {
        this.clientAdvisor = clientAdvisor;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    public List<Object> getCommunications() {
        return communications;
    }

    public void setCommunications(List<Object> communications) {
        this.communications = communications;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public List<ContactRelation> getContactRelations() {
        return contactRelations;
    }

    public void setContactRelations(List<ContactRelation> contactRelations) {
        this.contactRelations = contactRelations;
    }

    public String getContactRestrictions() {
        return contactRestrictions;
    }

    public void setContactRestrictions(String contactRestrictions) {
        this.contactRestrictions = contactRestrictions;
    }

    public String getCountryOfBirthId() {
        return countryOfBirthId;
    }

    public void setCountryOfBirthId(String countryOfBirthId) {
        this.countryOfBirthId = countryOfBirthId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getDoubleTaxTreaty() {
        return doubleTaxTreaty;
    }

    public void setDoubleTaxTreaty(String doubleTaxTreaty) {
        this.doubleTaxTreaty = doubleTaxTreaty;
    }

    public List<Email_> getEmails() {
        return emails;
    }

    public void setEmails(List<Email_> emails) {
        this.emails = emails;
    }

    public Integer getExpectedInvestmentAmount() {
        return expectedInvestmentAmount;
    }

    public void setExpectedInvestmentAmount(Integer expectedInvestmentAmount) {
        this.expectedInvestmentAmount = expectedInvestmentAmount;
    }

    public String getExpectedInvestmentCurrency() {
        return expectedInvestmentCurrency;
    }

    public void setExpectedInvestmentCurrency(String expectedInvestmentCurrency) {
        this.expectedInvestmentCurrency = expectedInvestmentCurrency;
    }

    public String getFatcaClassification() {
        return fatcaClassification;
    }

    public void setFatcaClassification(String fatcaClassification) {
        this.fatcaClassification = fatcaClassification;
    }

    public String getFinancialAversions() {
        return financialAversions;
    }

    public void setFinancialAversions(String financialAversions) {
        this.financialAversions = financialAversions;
    }

    public List<Object> getFinancialInterests() {
        return financialInterests;
    }

    public void setFinancialInterests(List<Object> financialInterests) {
        this.financialInterests = financialInterests;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Object> getGifts() {
        return gifts;
    }

    public void setGifts(List<Object> gifts) {
        this.gifts = gifts;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public List<Object> getGroupRelations() {
        return groupRelations;
    }

    public void setGroupRelations(List<Object> groupRelations) {
        this.groupRelations = groupRelations;
    }

    public List<Object> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Object> hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdDocumentExpiryDate() {
        return idDocumentExpiryDate;
    }

    public void setIdDocumentExpiryDate(String idDocumentExpiryDate) {
        this.idDocumentExpiryDate = idDocumentExpiryDate;
    }

    public String getIdDocumentNationality() {
        return idDocumentNationality;
    }

    public void setIdDocumentNationality(String idDocumentNationality) {
        this.idDocumentNationality = idDocumentNationality;
    }

    public String getIncomeReferenceYear() {
        return incomeReferenceYear;
    }

    public void setIncomeReferenceYear(String incomeReferenceYear) {
        this.incomeReferenceYear = incomeReferenceYear;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public List<Object> getIndustryActivities() {
        return industryActivities;
    }

    public void setIndustryActivities(List<Object> industryActivities) {
        this.industryActivities = industryActivities;
    }

    public String getJointAccountTreatment() {
        return jointAccountTreatment;
    }

    public void setJointAccountTreatment(String jointAccountTreatment) {
        this.jointAccountTreatment = jointAccountTreatment;
    }

    public List<Object> getJurisdictions() {
        return jurisdictions;
    }

    public void setJurisdictions(List<Object> jurisdictions) {
        this.jurisdictions = jurisdictions;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLegalAndTaxAdvisor() {
        return legalAndTaxAdvisor;
    }

    public void setLegalAndTaxAdvisor(String legalAndTaxAdvisor) {
        this.legalAndTaxAdvisor = legalAndTaxAdvisor;
    }

    public String getManualRiskCategory() {
        return manualRiskCategory;
    }

    public void setManualRiskCategory(String manualRiskCategory) {
        this.manualRiskCategory = manualRiskCategory;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
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

    public String getNationalIdentificationCode() {
        return nationalIdentificationCode;
    }

    public void setNationalIdentificationCode(String nationalIdentificationCode) {
        this.nationalIdentificationCode = nationalIdentificationCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Integer getNumberedCommonId() {
        return numberedCommonId;
    }

    public void setNumberedCommonId(Integer numberedCommonId) {
        this.numberedCommonId = numberedCommonId;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public List<Integer> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(List<Integer> opportunities) {
        this.opportunities = opportunities;
    }

    public List<Object> getOtherChannels() {
        return otherChannels;
    }

    public void setOtherChannels(List<Object> otherChannels) {
        this.otherChannels = otherChannels;
    }

    public String getOtherFinancialAdvisor() {
        return otherFinancialAdvisor;
    }

    public void setOtherFinancialAdvisor(String otherFinancialAdvisor) {
        this.otherFinancialAdvisor = otherFinancialAdvisor;
    }

    public List<Object> getOtherNationalities() {
        return otherNationalities;
    }

    public void setOtherNationalities(List<Object> otherNationalities) {
        this.otherNationalities = otherNationalities;
    }

    public List<String> getOtherTaxResidencies() {
        return otherTaxResidencies;
    }

    public void setOtherTaxResidencies(List<String> otherTaxResidencies) {
        this.otherTaxResidencies = otherTaxResidencies;
    }

    public Integer getOverallEstimatedFinancialAssets() {
        return overallEstimatedFinancialAssets;
    }

    public void setOverallEstimatedFinancialAssets(Integer overallEstimatedFinancialAssets) {
        this.overallEstimatedFinancialAssets = overallEstimatedFinancialAssets;
    }

    public String getOverallEstimatedFinancialAssetsCurrency() {
        return overallEstimatedFinancialAssetsCurrency;
    }

    public void setOverallEstimatedFinancialAssetsCurrency(String overallEstimatedFinancialAssetsCurrency) {
        this.overallEstimatedFinancialAssetsCurrency = overallEstimatedFinancialAssetsCurrency;
    }

    public Integer getOverallEstimatedNonFinancialAssets() {
        return overallEstimatedNonFinancialAssets;
    }

    public void setOverallEstimatedNonFinancialAssets(Integer overallEstimatedNonFinancialAssets) {
        this.overallEstimatedNonFinancialAssets = overallEstimatedNonFinancialAssets;
    }

    public String getOverallEstimatedNonFinancialAssetsCurrency() {
        return overallEstimatedNonFinancialAssetsCurrency;
    }

    public void setOverallEstimatedNonFinancialAssetsCurrency(String overallEstimatedNonFinancialAssetsCurrency) {
        this.overallEstimatedNonFinancialAssetsCurrency = overallEstimatedNonFinancialAssetsCurrency;
    }

    public List<Object> getPartyRoles() {
        return partyRoles;
    }

    public void setPartyRoles(List<Object> partyRoles) {
        this.partyRoles = partyRoles;
    }

    public String getPep() {
        return pep;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }

    public String getPepComment() {
        return pepComment;
    }

    public void setPepComment(String pepComment) {
        this.pepComment = pepComment;
    }

    public String getPepElement() {
        return pepElement;
    }

    public void setPepElement(String pepElement) {
        this.pepElement = pepElement;
    }

    public Boolean getPersonKnownToBanker() {
        return personKnownToBanker;
    }

    public void setPersonKnownToBanker(Boolean personKnownToBanker) {
        this.personKnownToBanker = personKnownToBanker;
    }

    public PersonalContactRelation getPersonalContactRelation() {
        return personalContactRelation;
    }

    public void setPersonalContactRelation(PersonalContactRelation personalContactRelation) {
        this.personalContactRelation = personalContactRelation;
    }

    public List<Phone_> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone_> phones) {
        this.phones = phones;
    }

    public String getPictureURN() {
        return pictureURN;
    }

    public void setPictureURN(String pictureURN) {
        this.pictureURN = pictureURN;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getPreferredComunicationChannel() {
        return preferredComunicationChannel;
    }

    public void setPreferredComunicationChannel(String preferredComunicationChannel) {
        this.preferredComunicationChannel = preferredComunicationChannel;
    }

    public String getPreferredIndustries() {
        return preferredIndustries;
    }

    public void setPreferredIndustries(String preferredIndustries) {
        this.preferredIndustries = preferredIndustries;
    }

    public String getPreferredInstrumentArea() {
        return preferredInstrumentArea;
    }

    public void setPreferredInstrumentArea(String preferredInstrumentArea) {
        this.preferredInstrumentArea = preferredInstrumentArea;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getPreferredMarkets() {
        return preferredMarkets;
    }

    public void setPreferredMarkets(String preferredMarkets) {
        this.preferredMarkets = preferredMarkets;
    }

    public PreviousAssignment getPreviousAssignment() {
        return previousAssignment;
    }

    public void setPreviousAssignment(PreviousAssignment previousAssignment) {
        this.previousAssignment = previousAssignment;
    }

    public List<String> getProfession() {
        return profession;
    }

    public void setProfession(List<String> profession) {
        this.profession = profession;
    }

    public Integer getReferralIncome() {
        return referralIncome;
    }

    public void setReferralIncome(Integer referralIncome) {
        this.referralIncome = referralIncome;
    }

    public String getReferralIncomeCurrency() {
        return referralIncomeCurrency;
    }

    public void setReferralIncomeCurrency(String referralIncomeCurrency) {
        this.referralIncomeCurrency = referralIncomeCurrency;
    }

    public String getReferralType() {
        return referralType;
    }

    public void setReferralType(String referralType) {
        this.referralType = referralType;
    }

    public List<Object> getReports() {
        return reports;
    }

    public void setReports(List<Object> reports) {
        this.reports = reports;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public List<Object> getRiskProfileHistories() {
        return riskProfileHistories;
    }

    public void setRiskProfileHistories(List<Object> riskProfileHistories) {
        this.riskProfileHistories = riskProfileHistories;
    }

    public String getSmartKYCReviewId() {
        return smartKYCReviewId;
    }

    public void setSmartKYCReviewId(String smartKYCReviewId) {
        this.smartKYCReviewId = smartKYCReviewId;
    }

    public String getSourceOfWealth() {
        return sourceOfWealth;
    }

    public void setSourceOfWealth(String sourceOfWealth) {
        this.sourceOfWealth = sourceOfWealth;
    }

    public Suitability getSuitability() {
        return suitability;
    }

    public void setSuitability(Suitability suitability) {
        this.suitability = suitability;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTaxRegionId() {
        return taxRegionId;
    }

    public void setTaxRegionId(String taxRegionId) {
        this.taxRegionId = taxRegionId;
    }

    public List<Object> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Object> taxes) {
        this.taxes = taxes;
    }

    public Integer getUpdateVersion() {
        return updateVersion;
    }

    public void setUpdateVersion(Integer updateVersion) {
        this.updateVersion = updateVersion;
    }

    public String getUsAssetsAccountHolderTrade() {
        return usAssetsAccountHolderTrade;
    }

    public void setUsAssetsAccountHolderTrade(String usAssetsAccountHolderTrade) {
        this.usAssetsAccountHolderTrade = usAssetsAccountHolderTrade;
    }

    public String getUsAssetsTradeAllowed() {
        return usAssetsTradeAllowed;
    }

    public void setUsAssetsTradeAllowed(String usAssetsTradeAllowed) {
        this.usAssetsTradeAllowed = usAssetsTradeAllowed;
    }

    public String getUsBorn() {
        return usBorn;
    }

    public void setUsBorn(String usBorn) {
        this.usBorn = usBorn;
    }

    public String getUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(String usCitizen) {
        this.usCitizen = usCitizen;
    }

    public String getUsGreenCardHolder() {
        return usGreenCardHolder;
    }

    public void setUsGreenCardHolder(String usGreenCardHolder) {
        this.usGreenCardHolder = usGreenCardHolder;
    }

    public Boolean getUsIndiciaFound() {
        return usIndiciaFound;
    }

    public void setUsIndiciaFound(Boolean usIndiciaFound) {
        this.usIndiciaFound = usIndiciaFound;
    }

    public String getUsPresenceTest() {
        return usPresenceTest;
    }

    public void setUsPresenceTest(String usPresenceTest) {
        this.usPresenceTest = usPresenceTest;
    }

    public String getUsTaxPayer() {
        return usTaxPayer;
    }

    public void setUsTaxPayer(String usTaxPayer) {
        this.usTaxPayer = usTaxPayer;
    }

    public String getWealthCategory() {
        return wealthCategory;
    }

    public void setWealthCategory(String wealthCategory) {
        this.wealthCategory = wealthCategory;
    }

    public List<String> getWealthCreationCountries() {
        return wealthCreationCountries;
    }

    public void setWealthCreationCountries(List<String> wealthCreationCountries) {
        this.wealthCreationCountries = wealthCreationCountries;
    }

    public String getWealthCurrentStage() {
        return wealthCurrentStage;
    }

    public void setWealthCurrentStage(String wealthCurrentStage) {
        this.wealthCurrentStage = wealthCurrentStage;
    }

    public String getWealthStructureAllocation() {
        return wealthStructureAllocation;
    }

    public void setWealthStructureAllocation(String wealthStructureAllocation) {
        this.wealthStructureAllocation = wealthStructureAllocation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package com.insurance.model;


import java.util.Date;


public class ClaimModel {

    private String claimReference;
    private Date incidentDate;
    private String claimantName;
    private String claimantDetail;
    private String insurer;
    private String state;

    public String getClaimReference() {
        return claimReference;
    }

    public void setClaimReference(String claimReference) {
        this.claimReference = claimReference;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public String getClaimantDetail() {
        return claimantDetail;
    }

    public void setClaimantDetail(String claimantDetail) {
        this.claimantDetail = claimantDetail;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

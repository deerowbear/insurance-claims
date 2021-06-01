package com.insurance.service.persistence.domain.claim;

import com.insurance.service.persistence.domain.head.HeadClaim;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="CLAIM")
public class Claim implements Serializable {

    @Id
    @Column(name = "claim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @Column(name="claimReference")
    private String claimReference;

    @Column(name="incidentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incidentDate;

    @Column(name="claimantName")
    private String claimantName;

    @Column(name="claimantDetail")
    private String claimantDetail;

    @Column(name="insurer")
    private String insurer;

    @Column(name="state")
    private String state;

    @OneToMany(mappedBy = "claim" , fetch = FetchType.LAZY , cascade = CascadeType.REMOVE , orphanRemoval = true)
    private Set<HeadClaim> headClaims;

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

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

    public Set<HeadClaim> getHeadClaims() {
        return headClaims;
    }

    public void setHeadClaims(Set<HeadClaim> headClaims) {
        this.headClaims = headClaims;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Claim other = (Claim) obj;
        if (claimId == null) {
            if (other.claimId != null)
                return false;
        } else if (!claimId.equals(other.claimId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("com.insurance.service.persistence.domain.claim.Claim[ id=" + claimId);
        sb.append("\n claimReference = ").append(claimReference);
        sb.append("\n incidentDate = ").append(incidentDate);
        sb.append("\n claimantName = ").append(claimantName);
        sb.append("\n claimantDetail = ").append(claimantDetail);
        sb.append("\n insurer = ").append(insurer);
        sb.append("\n state = ").append(state);
        sb.append(" ]");
        return sb.toString();
    }
}

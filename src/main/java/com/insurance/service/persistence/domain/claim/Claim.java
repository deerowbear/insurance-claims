package com.insurance.service.persistence.domain.claim;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="CLAIM")
public class Claim implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="claimReference")
    private String claimReference;

    @Column(name="incidentDate")
    private Date incidentDate;

    @Column(name="name")
    private String name;

    @Column(name="insurer")
    private String insurer;

    @Column(name="state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Claim other = (Claim) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("com.insurance.service.persistence.domain.claim.Claim[ id=" + id);
        sb.append("\n claimReference = ").append(claimReference);
        sb.append("\n incidentDate = ").append(incidentDate);
        sb.append("\n name = ").append(name);
        sb.append("\n insurer = ").append(insurer);
        sb.append("\n state = ").append(state);
        sb.append(" ]");
        return sb.toString();
    }
}

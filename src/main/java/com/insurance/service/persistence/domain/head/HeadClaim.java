package com.insurance.service.persistence.domain.head;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insurance.service.persistence.domain.claim.Claim;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HEAD_CLAIM")
public class HeadClaim  implements Serializable {

    @Id
    @Column(name = "head_claim_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long headClaimId;

    @Basic(optional = false)
    @Column(name = "claim_id")
    private Long claimId;

    @Column(name="cost")
    private Integer cost;

    @Column(name="detail")
    private String detail;

    @Column(name="state")
    private String state;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "claim_id", insertable = false, updatable = false)
    private Claim claim;

    public Long getHeadClaimId() {
        return headClaimId;
    }

    public void setHeadClaimId(Long headClaimId) {
        this.headClaimId = headClaimId;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        HeadClaim other = (HeadClaim) obj;
        if (headClaimId == null) {
            if (other.headClaimId != null)
                return false;
        } else if (!headClaimId.equals(other.headClaimId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("com.insurance.service.persistence.domain.head.HeadClaim[ id=" + headClaimId);
        sb.append("\n cost = ").append(cost);
        sb.append("\n detail = ").append(detail);
        sb.append("\n state = ").append(state);
        sb.append(" ]");
        return sb.toString();
    }

}

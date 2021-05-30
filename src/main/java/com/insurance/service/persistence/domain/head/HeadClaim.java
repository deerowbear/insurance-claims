package com.insurance.service.persistence.domain.head;

import com.insurance.service.persistence.domain.claim.Claim;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CLAIM_HEAD")
public class HeadClaim  implements Serializable {

/**
 * •	costs and details
 * (These will differ dependant on whether this is a vehicle damage, recovery or storage loss)
 * •	state
 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cost")
    private Integer cost;

    @Column(name="detail")
    private String detail;

    @Column(name="state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        HeadClaim other = (HeadClaim) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("com.insurance.service.persistence.domain.head.HeadClaim[ id=" + id);
        sb.append("\n cost = ").append(cost);
        sb.append("\n detail = ").append(detail);
        sb.append("\n state = ").append(state);
        sb.append(" ]");
        return sb.toString();
    }

}

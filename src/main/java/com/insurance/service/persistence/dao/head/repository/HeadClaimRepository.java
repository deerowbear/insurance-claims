package com.insurance.service.persistence.dao.head.repository;

import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.domain.head.HeadClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HeadClaimRepository extends JpaRepository<HeadClaim, Long> {

}

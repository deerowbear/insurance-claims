package com.insurance.service.persistence.dao.claim.repository;

import com.insurance.service.persistence.domain.claim.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {



}

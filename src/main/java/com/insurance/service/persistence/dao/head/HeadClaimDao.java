package com.insurance.service.persistence.dao.head;

import com.insurance.service.persistence.dao.SimpleCrudDao;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.domain.head.HeadClaim;
import com.insurance.service.persistence.exception.DataNotFoundException;

import javax.persistence.PersistenceException;
import java.util.List;

public interface HeadClaimDao extends SimpleCrudDao<HeadClaim, Long> {

    public List<HeadClaim> findAll() throws PersistenceException, DataNotFoundException;

}

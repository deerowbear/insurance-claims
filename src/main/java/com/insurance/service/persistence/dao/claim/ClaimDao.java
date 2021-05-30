package com.insurance.service.persistence.dao.claim;

import com.insurance.service.persistence.dao.SimpleCrudDao;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.exception.DataNotFoundException;

import javax.persistence.PersistenceException;
import java.util.List;

public interface ClaimDao extends SimpleCrudDao<Claim, Long> {

    public List<Claim> findAll() throws PersistenceException, DataNotFoundException;

}

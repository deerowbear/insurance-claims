package com.insurance.service.persistence.dao.head;

import com.insurance.service.persistence.dao.head.repository.HeadClaimRepository;
import com.insurance.service.persistence.domain.head.HeadClaim;
import com.insurance.service.persistence.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

public class HeadClaimDaoImpl implements HeadClaimDao {

    private final HeadClaimRepository headClaimRepository;

    @Autowired
    public HeadClaimDaoImpl(HeadClaimRepository headClaimRepository) {
        this.headClaimRepository = headClaimRepository;
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public List<HeadClaim> findAll() throws PersistenceException, DataNotFoundException {
        return headClaimRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public HeadClaim findById(Long id) throws DataNotFoundException, PersistenceException {
        if ( id == null ) {
            throw new DataNotFoundException("HeadClaim id " + id + " does not exist");
        }
        try {
            return headClaimRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new DataNotFoundException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public HeadClaim create(HeadClaim headClaim) throws PersistenceException, PersistenceException {
        if ( headClaim == null ) {
            throw new IllegalArgumentException("HeadClaim object can not be null");
        }
        return headClaimRepository.save(headClaim);
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public HeadClaim update(HeadClaim headClaim) throws DataNotFoundException, PersistenceException, DataNotFoundException {
        if ( headClaim == null ) {
            throw new IllegalArgumentException("Claim object can not be null");
        }
        try {
            return headClaimRepository.saveAndFlush(headClaim);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public void deleteById(Long id) throws DataNotFoundException, PersistenceException {
        if ( !headClaimRepository.existsById(id) ) {
            throw new DataNotFoundException("HeadClaim with id " + id + " does not exist");
        }
        try {
            HeadClaim headClaim = headClaimRepository.getById(id);
            headClaimRepository.delete(headClaim);
            headClaimRepository.flush();
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public boolean exists(Long id) throws PersistenceException {
        if ( id == null ) {
            throw new IllegalArgumentException("Claim id can not be null");
        }
        try {
            return headClaimRepository.existsById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

}

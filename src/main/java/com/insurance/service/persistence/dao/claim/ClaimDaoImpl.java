package com.insurance.service.persistence.dao.claim;

import com.insurance.service.persistence.dao.claim.repository.ClaimRepository;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;


@Repository
public class ClaimDaoImpl implements ClaimDao {

    private final ClaimRepository claimRepository;

    @Autowired
    public ClaimDaoImpl(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }


    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public List<Claim> findAll() throws PersistenceException, DataNotFoundException {
        return claimRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Claim findById(Long id) throws DataNotFoundException, PersistenceException {
        if ( id == null ) {
            throw new DataNotFoundException("Offer id " + id + " does not exist");
        }
        try {
            return claimRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new DataNotFoundException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Claim create(Claim claim) throws PersistenceException, PersistenceException {
        if ( claim == null ) {
            throw new IllegalArgumentException("Claim object can not be null");
        }
        return claimRepository.save(claim);
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public Claim update(Claim offer) throws DataNotFoundException, PersistenceException, DataNotFoundException {
        if ( offer == null ) {
            throw new IllegalArgumentException("Claim object can not be null");
        }
        try {
            return claimRepository.saveAndFlush(offer);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public void deleteById(Long id) throws DataNotFoundException, PersistenceException {
        if ( !claimRepository.existsById(id) ) {
            throw new DataNotFoundException("Offer with id " + id + " does not exist");
        }
        try {
            Claim claim = claimRepository.getOne(id);
            claimRepository.delete(claim);
            claimRepository.flush();
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }


    @Override
    @Transactional(readOnly = true , propagation = Propagation.REQUIRED)
    public boolean exists(Long id) throws PersistenceException {
        if ( id == null ) {
            throw new IllegalArgumentException("Offer id can not be null");
        }
        try {
            return claimRepository.existsById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }
}

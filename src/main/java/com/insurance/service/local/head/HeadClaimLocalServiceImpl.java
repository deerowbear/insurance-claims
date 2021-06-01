package com.insurance.service.local.head;

import com.insurance.model.HeadClaimModel;
import com.insurance.service.modelmapper.claim.HeadClaimModelMapper;
import com.insurance.service.persistence.dao.head.HeadClaimDao;
import com.insurance.service.persistence.domain.head.HeadClaim;
import com.insurance.service.persistence.exception.DataNotFoundException;
import com.insurance.service.persistence.exception.LocalServiceException;
import com.insurance.util.ModelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class HeadClaimLocalServiceImpl implements HeadClaimLocalService {

    private static final Logger LOG = Logger.getLogger(HeadClaimLocalServiceImpl.class.getName());

    @Autowired
    HeadClaimDao headClaimDao;

    @Override
    public List<HeadClaimModel> list() throws LocalServiceException {
        try {
            List<HeadClaim> headClaims = headClaimDao.findAll();
            return ModelUtils.toModels(headClaims, HeadClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public HeadClaimModel findById(long id) throws LocalServiceException {
        try {
            return ModelUtils.toModel(headClaimDao.findById(id), HeadClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public HeadClaimModel create(HeadClaimModel headClaimModel) throws LocalServiceException {
        try {
            HeadClaim headClaim = ModelUtils.toDomain(headClaimModel, HeadClaimModelMapper.class);
            return ModelUtils.toModel(headClaimDao.create(headClaim), HeadClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public HeadClaimModel update(long id, HeadClaimModel headClaimModel) throws LocalServiceException {
        try {
            HeadClaimModel updateHeadClaimModel = findById(id);
            HeadClaim headClaim = ModelUtils.toDomain(updateHeadClaimModel, HeadClaimModelMapper.class);
            return ModelUtils.toModel(headClaimDao.update(headClaim), HeadClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public void delete(long id) throws LocalServiceException {
        try {
            headClaimDao.deleteById(id);
        } catch (PersistenceException | DataNotFoundException ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }
}

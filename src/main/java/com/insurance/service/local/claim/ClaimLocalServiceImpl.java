package com.insurance.service.local.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.modelmapper.claim.ClaimModelMapper;
import com.insurance.service.persistence.dao.claim.ClaimDao;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.exception.DataNotFoundException;
import com.insurance.service.persistence.exception.LocalServiceException;
import com.insurance.util.ModelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class ClaimLocalServiceImpl implements  ClaimLocalService {

    private static final Logger LOG = Logger.getLogger(ClaimLocalServiceImpl.class.getName());

    @Autowired
    ClaimDao claimDao;

    @Override
    public List<ClaimModel> list() throws LocalServiceException {
        try {
            return ModelUtils.toModels(claimDao.findAll(), ClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public ClaimModel findById(long id) throws LocalServiceException {
        try {
            return ModelUtils.toModel(claimDao.findById(id), ClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public ClaimModel create(ClaimModel claimModel) throws LocalServiceException {
        try {
            Claim claim = ModelUtils.toDomain(claimModel, ClaimModelMapper.class);
            return ModelUtils.toModel(claimDao.create(claim), ClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public ClaimModel update(long id, ClaimModel claimModel) throws LocalServiceException {
        try {
            ClaimModel updateClaimModel = this.findById(id);
            updateClaimModel.setClaimantDetail(claimModel.getClaimantDetail());
            updateClaimModel.setClaimantName(claimModel.getClaimantName());
            updateClaimModel.setClaimReference(claimModel.getClaimReference());
            updateClaimModel.setInsurer(claimModel.getInsurer());
            updateClaimModel.setState(claimModel.getState());
            Claim claim = ModelUtils.toDomain(updateClaimModel, ClaimModelMapper.class);
            return ModelUtils.toModel(claimDao.update(claim), ClaimModelMapper.class);
        } catch (Exception ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }

    @Override
    public void delete(long id) throws LocalServiceException {
        try {
            claimDao.deleteById(id);
        } catch (PersistenceException | DataNotFoundException ex) {
            LOG.error(ex);
            throw new LocalServiceException(ex);
        }
    }
}

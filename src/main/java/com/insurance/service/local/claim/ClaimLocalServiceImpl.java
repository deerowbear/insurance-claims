package com.insurance.service.local.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.modelmapper.claim.ClaimModelMapper;
import com.insurance.service.persistence.dao.claim.ClaimDao;
import com.insurance.service.persistence.exception.LocalServiceException;
import com.insurance.util.ModelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

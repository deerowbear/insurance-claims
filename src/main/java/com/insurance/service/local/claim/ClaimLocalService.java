package com.insurance.service.local.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.persistence.exception.LocalServiceException;

import java.util.List;

public interface ClaimLocalService {

    public List<ClaimModel> list() throws LocalServiceException;

    public ClaimModel findById(long id) throws LocalServiceException;

    public ClaimModel create(ClaimModel claimModel) throws LocalServiceException;

    public ClaimModel update(long id, ClaimModel claimModel) throws LocalServiceException;

    public void delete(long id) throws LocalServiceException;


}

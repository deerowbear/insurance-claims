package com.insurance.service.local.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.persistence.exception.LocalServiceException;

import java.util.List;

public interface ClaimLocalService {

    public List<ClaimModel> list() throws LocalServiceException;

}

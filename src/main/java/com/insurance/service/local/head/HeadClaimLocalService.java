package com.insurance.service.local.head;

import com.insurance.model.HeadClaimModel;
import com.insurance.service.persistence.exception.LocalServiceException;

import java.util.List;

public interface HeadClaimLocalService {

    public List<HeadClaimModel> list() throws LocalServiceException;

    public HeadClaimModel findById(long id) throws LocalServiceException;

    public HeadClaimModel create(HeadClaimModel headClaimModel) throws LocalServiceException;

    public HeadClaimModel update(long id, HeadClaimModel headClaimModel) throws LocalServiceException;

    public void delete(long id) throws LocalServiceException;

}

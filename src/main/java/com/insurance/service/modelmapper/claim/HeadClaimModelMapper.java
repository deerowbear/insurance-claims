package com.insurance.service.modelmapper.claim;

import com.insurance.model.ClaimModel;
import com.insurance.model.HeadClaimModel;
import com.insurance.service.modelmapper.BaseModelMapper;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.service.persistence.domain.head.HeadClaim;
import com.insurance.util.ModelMapper;
import com.insurance.util.ModelMapperException;

public class HeadClaimModelMapper extends BaseModelMapper implements ModelMapper<HeadClaimModel, HeadClaim> {


    @Override
    public HeadClaimModel toModel(HeadClaim headClaim) throws ModelMapperException {
        HeadClaimModel headClaimModel = new HeadClaimModel();
        headClaimModel.setCost(headClaim.getCost());
        headClaimModel.setDetail(headClaim.getDetail());
        headClaimModel.setState(headClaim.getState());
        return headClaimModel;
    }

    @Override
    public HeadClaim toDomain(HeadClaimModel headClaimModel) throws ModelMapperException {
        HeadClaim headClaim = new HeadClaim();
        headClaim.setCost(headClaimModel.getCost());
        headClaim.setDetail(headClaimModel.getDetail());
        headClaim.setState(headClaimModel.getState());
        return headClaim;
    }
}

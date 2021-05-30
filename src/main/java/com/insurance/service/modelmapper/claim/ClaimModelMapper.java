package com.insurance.service.modelmapper.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.modelmapper.BaseModelMapper;
import com.insurance.service.persistence.domain.claim.Claim;
import com.insurance.util.ModelMapper;
import com.insurance.util.ModelMapperException;

public class ClaimModelMapper extends BaseModelMapper implements ModelMapper<ClaimModel, Claim> {


    @Override
    public ClaimModel toModel(Claim claim) throws ModelMapperException {
        ClaimModel claimModel = new ClaimModel();
        claimModel.setClaimReference(claim.getClaimReference());
        claimModel.setIncidentDate(claim.getIncidentDate());
        claimModel.setInsurer(claim.getInsurer());
        claimModel.setName(claim.getName());
        claimModel.setDetail(claim.getDetail());
        claimModel.setState(claim.getState());
        return claimModel;
    }

    @Override
    public Claim toDomain(ClaimModel claimModel) throws ModelMapperException {
        Claim claim = new Claim();
        claim.setClaimReference(claimModel.getClaimReference());
        claim.setIncidentDate(claimModel.getIncidentDate());
        claim.setInsurer(claimModel.getInsurer());
        claim.setName(claimModel.getName());
        claim.setDetail(claimModel.getDetail());
        claim.setState(claimModel.getState());
        return claim;
    }
}

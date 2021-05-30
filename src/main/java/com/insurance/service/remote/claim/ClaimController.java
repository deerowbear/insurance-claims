package com.insurance.service.remote.claim;

import com.insurance.model.ClaimModel;
import com.insurance.service.local.claim.ClaimLocalService;
import com.insurance.service.remote.BaseRemoteServiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("v1.ClaimController")
@RequestMapping("/ws/v1/claim")
public class ClaimController extends BaseRemoteServiceController {

    @Autowired
    ClaimLocalService claimLocalService;

    @RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClaimModel> list(@RequestParam(required = false) Boolean canceled)  throws Exception {
        return claimLocalService.list();
    }


}

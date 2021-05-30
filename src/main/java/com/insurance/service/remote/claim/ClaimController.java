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

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClaimModel create(@RequestBody ClaimModel claimModel)  throws Exception {
        return claimLocalService.create(claimModel);
    }

    @RequestMapping(value = { "/update/{id}" }, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClaimModel update(@PathVariable long id,@RequestBody ClaimModel claimModel)  throws Exception {
        return claimLocalService.update(id, claimModel);
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable long id)  throws Exception {
        claimLocalService.delete(id);
    }


}

package com.mohammedAlghafri.CDR.Controller;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.RequestObject.GetCDRsRequestObject;
import com.mohammedAlghafri.CDR.ResponseObjects.GetCDRsResponse;
import com.mohammedAlghafri.CDR.Service.CDRsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CDRsController {

    @Autowired
    CDRsService cdrsService;


    @RequestMapping("/api/cdr")
    public void saveCDRs(@RequestBody GetCDRsRequestObject cdrRequestObject) {

        createCDRs(cdrRequestObject);
    }

    @RequestMapping("get/cdr")
    public List<CDRs> getCDRs() {
        return cdrsService.getCDRs();
    }


    @RequestMapping("/api/cdrs/{cdrsId}")
    public GetCDRsResponse createCDRs(@PathVariable Long cdrsId) {
        return cdrsService.getCDRsById(cdrsId);
    }






    public void createCDRs(GetCDRsRequestObject cdRsRequestObject) {

        CDRs cdrs = new CDRs();

        cdrs.setCaller_number(cdRsRequestObject.getCaller_number());
        cdrs.setReceiver_number(cdRsRequestObject.getReceiver_number());
        cdrs.setDuration(cdRsRequestObject.getDuration());
        cdrs.setTimestamp(cdRsRequestObject.getTimestamp());
        cdrs.setUpdatedDate(new Date());
        cdrs.setCreatedDate(new Date());
        cdrs.setIsActive(true);
        cdrsService.saveCDRs(cdrs);
    }
}

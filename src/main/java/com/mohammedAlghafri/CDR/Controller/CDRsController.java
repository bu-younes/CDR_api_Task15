package com.mohammedAlghafri.CDR.Controller;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.RequestObject.GetCDRsRequestObject;
import com.mohammedAlghafri.CDR.Service.CDRsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "cdrs")
public class CDRsController {

    @Autowired
    CDRsService cdrsService;


    @RequestMapping("/api/cdrs")
    public void saveCDRs(@RequestBody GetCDRsRequestObject cdrsRequestObject) {

        createCDRs(cdrsRequestObject);
    }

    @RequestMapping("get")
    public List<CDRs> getCDRs() {
        return cdrsService.getCDRs();
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

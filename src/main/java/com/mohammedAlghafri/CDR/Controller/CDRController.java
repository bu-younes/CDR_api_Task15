package com.mohammedAlghafri.CDR.Controller;


import com.mohammedAlghafri.CDR.Models.CDR;
import com.mohammedAlghafri.CDR.RequestObject.GetCDRRequestObject;
import com.mohammedAlghafri.CDR.Service.CDRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "cdrs")
public class CDRController {


    @Autowired
    CDRService cdrService;


    @RequestMapping("create")
    public void saveCDR(@RequestBody GetCDRRequestObject cdrRequestObject) {
        createcdrs(cdrRequestObject);
    }

    @RequestMapping("get")
    public List<CDR> getCDR() {
        return cdrService.getCDR();
    }






    public void createcdrs(GetCDRRequestObject cdrRequestObject) {

        CDR cdr = new CDR();


        cdr.setCaller_number("1234567890");
        cdr.setReceiver_number("9876543210");
        cdr.setDuration("180");
        cdr.setTimestamp("2023-06-16T10:30:00Z");





        cdr.setCreatedDate(new Date());
        cdr.setIsActive(true);
        cdrService.saveCDR(cdr);

    }



}

package com.mohammedAlghafri.CDR.Controller;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.RequestObject.GetCDRsRequestObject;
import com.mohammedAlghafri.CDR.ResponseObjects.GetCDRsResponse;
import com.mohammedAlghafri.CDR.Service.CDRsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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


    @RequestMapping("api/cdrs/{cdrsId}")
    public GetCDRsResponse createCDRs(@PathVariable Long cdrsId) {
        return cdrsService.getCDRsById(cdrsId);
    }



    @GetMapping("/api/cdrs")
    public ResponseEntity<List<GetCDRsResponse>> searchCDRs(
            @RequestParam("caller_number") String callerNumber,
            @RequestParam("timestamp_from") String timestampFrom,
            @RequestParam("timestamp_to") String timestampTo) {
        List<CDRs> cdrs = cdrsService.searchCDRs(callerNumber, timestampFrom, timestampTo);
        List<GetCDRsResponse> cdrResponses = convertToCdrResponses(cdrs);
        return ResponseEntity.ok(cdrResponses);
    }

    private List<GetCDRsResponse> convertToCdrResponses(List<CDRs> cdrs) {
        List<GetCDRsResponse> cdrResponses = new ArrayList<>();
        for (CDRs cdr : cdrs) {
            cdrResponses.add(new GetCDRsResponse(
                    cdr.getCallerNumber(),
                    cdr.getReceiverNumber(),
                    cdr.getDuration(),
                    cdr.getTimestamp()
            ));
        }
        return cdrResponses;
    }


    @RequestMapping("/api/analytics/call_durations")
    public ResponseEntity<Map<String, Object>> getCdrs(){
        List<CDRs> getCdrs = cdrsService.getCdrs();
        Integer totalCalls =0;
        Integer totalDuration = 0;
        for( CDRs cdrs : getCdrs){
            totalCalls++;
            totalDuration = totalDuration + cdrs.getDuration();
        }
        Double average_duration = (double) (totalDuration/totalCalls);
        Map<String, Object> response = new HashMap<>();
        response.put("average_duration", average_duration);
        response.put("total_calls", totalCalls);
        return ResponseEntity.ok(response);
    }



    public void createCDRs(GetCDRsRequestObject cdRsRequestObject) {

        CDRs cdrs = new CDRs();

        cdrs.setCallerNumber(cdRsRequestObject.getCaller_number());
        cdrs.setReceiverNumber(cdRsRequestObject.getReceiver_number());
        cdrs.setDuration(cdRsRequestObject.getDuration());
        cdrs.setTimestamp(cdRsRequestObject.getTimestamp());
        cdrs.setUpdatedDate(new Date());
        cdrs.setCreatedDate(new Date());
        cdrs.setIsActive(true);
        cdrsService.saveCDRs(cdrs);
    }


}

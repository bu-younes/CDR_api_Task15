package com.mohammedAlghafri.CDR.Service;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.Repository.CDRsRepository;
import com.mohammedAlghafri.CDR.ResponseObjects.GetCDRsResponse;
import com.mohammedAlghafri.CDR.ResponseObjects.UserSummaryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CDRsService {


    @Autowired
    CDRsRepository cdrsRepository;

    public List<CDRs> getCDRs() {return cdrsRepository.findAll();
    }


    public GetCDRsResponse getCDRsById(Long cdrsId) {
        Optional<CDRs> optionalCDRs =  cdrsRepository.findById(cdrsId);
        if(!optionalCDRs.isEmpty())
        {
            CDRs cdRs =  optionalCDRs.get();
            GetCDRsResponse cdRsResponse = new GetCDRsResponse(cdRs.getCallerNumber(), cdRs.getReceiverNumber(), cdRs.getDuration(), cdRs.getTimestamp());
            return cdRsResponse;
        }

        return null;

    }



    public List<CDRs> searchCDRs(String callerNumber, String timestampFrom, String timestampTo) {
        return cdrsRepository.findByCallerNumberAndTimestampBetween(callerNumber, timestampFrom, timestampTo);
    }

    public void saveCDRs(CDRs cdrs) {cdrsRepository.save(cdrs); }


    public List<CDRs> getCdrs() {
        return cdrsRepository.findAll();
    }





    public UserSummaryReport getUserSummaryReport(String username) {
        List<CDRs> userCDRs = cdrsRepository.findByUsername(username);
        int totalCalls = userCDRs.size();
        int totalDuration = 0;
        for (CDRs cdr : userCDRs) {
            totalDuration += cdr.getDuration();
        }
        double averageDuration = totalDuration / (double) totalCalls;

        return new UserSummaryReport(username, totalCalls, totalDuration, averageDuration);
    }




    public void cdrsupdate(Long cdeId, String callerNumber, String receiverNumber, int duration, String timestamp) {
        Optional<CDRs> optionalCDRs = cdrsRepository.findById(cdeId);
        if (optionalCDRs.isPresent()) {
            CDRs cdrs = optionalCDRs.get();
            cdrs.setCallerNumber(callerNumber);
            cdrs.setReceiverNumber(receiverNumber);
            cdrs.setDuration(duration);
            cdrs.setTimestamp(timestamp);
            cdrsRepository.save(cdrs);
        } else {
            System.out.println("ERROR");
        }
    }


}

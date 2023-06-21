package com.mohammedAlghafri.CDR.Service;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.Repository.CDRsRepository;
import com.mohammedAlghafri.CDR.ResponseObjects.GetCDRsResponse;
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
            GetCDRsResponse cdRsResponse = new GetCDRsResponse(cdRs.getCaller_number(), cdRs.getReceiver_number(), cdRs.getDuration(), cdRs.getTimestamp());
            return cdRsResponse;
        }

        return null;

    }



    public void saveCDRs(CDRs cdrs) {cdrsRepository.save(cdrs); }
}

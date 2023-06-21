package com.mohammedAlghafri.CDR.Service;

import com.mohammedAlghafri.CDR.Models.CDRs;
import com.mohammedAlghafri.CDR.Repository.CDRsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CDRsService {


    @Autowired
    CDRsRepository cdrsRepository;

    public List<CDRs> getCDRs() {return cdrsRepository.findAll();
    }
    public void saveCDRs(CDRs cdrs) {cdrsRepository.save(cdrs); }
}

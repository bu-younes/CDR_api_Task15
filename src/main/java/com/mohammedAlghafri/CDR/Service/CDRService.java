package com.mohammedAlghafri.CDR.Service;

import com.mohammedAlghafri.CDR.Models.CDR;
import com.mohammedAlghafri.CDR.Repository.CDRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDRService {

    @Autowired
    CDRRepository cdrRepository;

    public List<CDR> getCDR() {return cdrRepository.findAll();
    }
    public void saveCDR(CDR cdr) {cdrRepository.save(cdr); }

}

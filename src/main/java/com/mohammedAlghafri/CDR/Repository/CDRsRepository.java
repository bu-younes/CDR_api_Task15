package com.mohammedAlghafri.CDR.Repository;

import com.mohammedAlghafri.CDR.Models.CDRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CDRsRepository extends JpaRepository<CDRs, Long> {

    List<CDRs> findByCallerNumberAndTimestampBetween(String callerNumber, String timestampFrom, String timestampTo);
    List<CDRs> findByUsername(String username);

}

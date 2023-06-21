package com.mohammedAlghafri.CDR.Repository;

import com.mohammedAlghafri.CDR.Models.CDRs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDRsRepository extends JpaRepository<CDRs, Long> {
}

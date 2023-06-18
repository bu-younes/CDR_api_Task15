package com.mohammedAlghafri.CDR.Repository;

import com.mohammedAlghafri.CDR.Models.CDR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CDRRepository extends JpaRepository<CDR, Long> {
}

package com.mohammedAlghafri.CDR.Models;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CDRs extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;


    String callerNumber;

    String receiverNumber;

    Integer duration;

    String timestamp;


}

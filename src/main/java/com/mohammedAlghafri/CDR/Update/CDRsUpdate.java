package com.mohammedAlghafri.CDR.Update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CDRsUpdate {

    String callerNumber;
    String receiverNumber;
    int duration;
    String timestamp;
}

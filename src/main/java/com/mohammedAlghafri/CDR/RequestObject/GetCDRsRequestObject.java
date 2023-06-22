package com.mohammedAlghafri.CDR.RequestObject;

import com.mohammedAlghafri.CDR.Models.CDRs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCDRsRequestObject {


    String caller_number;

    String receiver_number;

    Integer duration;

    String timestamp;

    public CDRs ConvertToCDR(){
        CDRs cdr = new CDRs();

        cdr.setCallerNumber(this.getCaller_number());
        cdr.setReceiverNumber(this.getReceiver_number());
        cdr.setDuration(this.getDuration());
        cdr.setTimestamp(this.getTimestamp());
        return cdr;
    }

}

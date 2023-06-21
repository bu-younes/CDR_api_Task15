package com.mohammedAlghafri.CDR.RequestObject;

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

    String duration;

    String timestamp;

}

package com.mohammedAlghafri.CDR.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCDRsResponse {

    String caller_number;

    String receiver_number;

    Integer duration;

    String timestamp;
}

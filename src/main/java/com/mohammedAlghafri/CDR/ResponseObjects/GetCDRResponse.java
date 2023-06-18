package com.mohammedAlghafri.CDR.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCDRResponse {

    String caller_number;

    String receiver_number;

    String duration;

    String timestamp;
}

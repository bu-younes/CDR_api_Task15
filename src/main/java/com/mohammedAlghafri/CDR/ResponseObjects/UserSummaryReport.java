package com.mohammedAlghafri.CDR.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSummaryReport {

    private String username;
    private int totalCalls;
    private int totalDuration;
    private double averageDuration;
}

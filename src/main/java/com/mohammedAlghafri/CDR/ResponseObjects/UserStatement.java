package com.mohammedAlghafri.CDR.ResponseObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserStatement {

    private String username;
    private int month;
    private int year;
    private int totalCalls;
    private int totalDuration;
    private double totalCharge;
}

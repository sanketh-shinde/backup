package com.example.el.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {

    private Integer empId;
    private String empName;
    private Integer totalLeavesEligible = 10;
    int totalLeavesTaken;
    private int balance;
    private List<LeavesTaken> leavesDetails;

}

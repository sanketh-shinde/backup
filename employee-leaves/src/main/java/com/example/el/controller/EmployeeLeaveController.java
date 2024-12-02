package com.example.el.controller;

import com.example.el.dto.LeavesTaken;
import com.example.el.dto.ResultDTO;
import com.example.el.entity.EmployeeLeave;
import com.example.el.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeLeave")
public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveService employeeLeaveService;

    @PostMapping("/applyLeave")
    public EmployeeLeave applyLeave(@RequestParam("empId") Integer empId,
                                    @RequestParam("leaveId") Integer leaveId,
                                    @RequestBody EmployeeLeave employeeLeave) {

        return employeeLeaveService.applyLeave(empId, leaveId, employeeLeave);
    }

    @GetMapping("/getLeaves/{empId}")
    public ResultDTO getLeavesById(@PathVariable Integer empId) {
        return employeeLeaveService.getLeavesByEmployeeId(empId);
    }

}

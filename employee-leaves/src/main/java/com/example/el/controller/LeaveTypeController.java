package com.example.el.controller;

import com.example.el.entity.LeaveType;
import com.example.el.service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @PostMapping("/create")
    public LeaveType createLeaveType(@RequestBody LeaveType leaveType) {
        return leaveTypeService.addLeaveType(leaveType);
    }

}

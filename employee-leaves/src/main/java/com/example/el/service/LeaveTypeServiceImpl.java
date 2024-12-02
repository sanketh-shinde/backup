package com.example.el.service;

import com.example.el.entity.LeaveType;
import com.example.el.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public LeaveType addLeaveType(LeaveType leaveType) {
        return leaveTypeRepository.save(leaveType);
    }

}

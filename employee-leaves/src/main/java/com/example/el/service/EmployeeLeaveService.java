package com.example.el.service;

import com.example.el.dto.ResultDTO;
import com.example.el.entity.EmployeeLeave;

public interface EmployeeLeaveService {

    EmployeeLeave applyLeave(Integer empId, Integer leaveId, EmployeeLeave employeeLeave);

    ResultDTO getLeavesByEmployeeId(Integer empId);

}

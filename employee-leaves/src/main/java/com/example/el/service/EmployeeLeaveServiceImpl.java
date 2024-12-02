package com.example.el.service;

import com.example.el.dto.LeavesTaken;
import com.example.el.dto.ResultDTO;
import com.example.el.entity.Employee;
import com.example.el.entity.EmployeeLeave;
import com.example.el.entity.LeaveType;
import com.example.el.repository.EmployeeLeaveRepository;
import com.example.el.repository.EmployeeRepository;
import com.example.el.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public LeaveTypeRepository leaveTypeRepository;

    @Autowired
    public EmployeeLeaveRepository employeeLeaveRepository;

    @Override
    public EmployeeLeave applyLeave(Integer empId, Integer leaveId, EmployeeLeave employeeLeave) {

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LeaveType leaveType = leaveTypeRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave Type not found"));

        employeeLeave.setEmployee(employee);
        employeeLeave.setLeaveType(leaveType);
        return employeeLeaveRepository.save(employeeLeave);
    }

    @Override
    public ResultDTO getLeavesByEmployeeId(Integer empId) {
        List<EmployeeLeave> leaveListOfEmp = employeeLeaveRepository.findByEmployeeId(empId);
        List<LeavesTaken> leavesTakenList = new ArrayList<>();

        String employeeName = null;
        // If no leaves found, we still need to set employee name based on empId
        if (leaveListOfEmp.isEmpty()) {
            Employee employee = employeeRepository.findById(empId)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));

            employeeName = employee.getName();
        }

        for (EmployeeLeave employeeLeave : leaveListOfEmp) {
            String leaveTypeName = employeeLeave.getLeaveType().getName();
            employeeName = employeeLeave.getEmployee().getName();

            // boolean to check if the leave type already exists in the list
            boolean found = false;

            // Check if this leave type is already present in the result list
            for (LeavesTaken existingLeave : leavesTakenList) {
                if (existingLeave.getLeaveName().equals(leaveTypeName)) {
                    // Increment the count of the existing leave type
                    existingLeave.setCount(existingLeave.getCount() + 1);
                    found = true;
                    break;
                }
            }

            // If the leave type was not found, add it to the list
            if (!found) {
                LeavesTaken newLeave = new LeavesTaken();
                newLeave.setLeaveName(leaveTypeName);
                newLeave.setCount(1);
                leavesTakenList.add(newLeave);
            }
        }

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setEmpId(empId);
        resultDTO.setEmpName(employeeName);
        resultDTO.setLeavesDetails(leavesTakenList);
        resultDTO.setTotalLeavesTaken(totalLeavesTaken(leavesTakenList));
        resultDTO.setBalance(leaveBalance(leavesTakenList, resultDTO.getTotalLeavesEligible()));

        return resultDTO;
    }

    public int leaveBalance(List<LeavesTaken> leavesTakenList, int totalLeaves) {
        int count = totalLeavesTaken(leavesTakenList);
        totalLeaves -= count;
        return totalLeaves;
    }

    public int totalLeavesTaken(List<LeavesTaken> leavesTakenList) {
        int count = 0;
        for (LeavesTaken leavesTaken : leavesTakenList) {
            count += leavesTaken.getCount();
        }
        return count;
    }

}

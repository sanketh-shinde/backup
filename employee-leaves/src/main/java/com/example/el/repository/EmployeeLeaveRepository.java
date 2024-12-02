package com.example.el.repository;

import com.example.el.entity.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Integer> {

    List<EmployeeLeave> findByEmployeeId(Integer id);

}

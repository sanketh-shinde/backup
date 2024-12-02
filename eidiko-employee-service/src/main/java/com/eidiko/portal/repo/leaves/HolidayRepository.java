package com.eidiko.portal.repo.leaves;

import com.eidiko.portal.entities.biometric.HolidayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayList, Integer> {
    List<HolidayList> findByHolidayYear(int year);
}

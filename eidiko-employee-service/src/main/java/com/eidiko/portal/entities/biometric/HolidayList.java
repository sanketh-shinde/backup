package com.eidiko.portal.entities.biometric;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HolidayList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int holidayListId;
	private Date holidayDate;
	private String holidayDesc;
	private int holidayYear;
	private long createdBy;
	
	
	
}

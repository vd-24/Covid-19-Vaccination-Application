package com.covid19.Models;


import java.time.LocalDate;

import com.covid19.Enums.Slot;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
    
	private String mobileNo;
	
	@FutureOrPresent
	private LocalDate dateOfBooking; 
	private boolean bookingStatus = false;
	
	
//	@Enumerated(EnumType.STRING)
	private String slot;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccinationCenter vaccinationCenter;
}

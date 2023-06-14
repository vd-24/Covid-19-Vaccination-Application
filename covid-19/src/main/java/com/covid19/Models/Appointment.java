package com.covid19.Models;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private String mobileNo;
	private String slot;
	private LocalDate dateOfBooking = LocalDate.now(); 
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	private Boolean bookingStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccinationCenter vaccinationCenter;
}

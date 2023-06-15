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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	@OneToOne(mappedBy = "appointment",cascade = CascadeType.ALL)
	private Member member;

	@OneToOne( mappedBy = "appointment",cascade = CascadeType.ALL)
	private VaccinationCenter vaccinationCenter;
}

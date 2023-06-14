package com.covid19.Models;


import java.time.LocalDate;

import com.covid19.Enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class IdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@NotEmpty(message = "Name is mandatory")
	@Size(min = 3, max = 20, message = "Name length should be of size 3-20")
	private String Name;
	
	@Past
	private LocalDate DateOfBirth ;
	
	@NotNull(message = "Gender can't be null")
	@Enumerated
	private Gender gender;
	
	@NotEmpty(message =  "Address is mandatory")
	private String Address ;
	
	@NotEmpty(message =  "City is mandatory")
	@Size(min = 2, max = 30 , message = "City length should be of size 3-20")
	private String city ;
	
	@NotEmpty(message =  "State is mandatory")
	@Size(min = 2, max = 30 , message = "State length should be of size 3-20")
	private String State ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PanCard panCard;
	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard adharCard;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
}
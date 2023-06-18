package com.covid19.Models;


import java.time.LocalDate;

import com.covid19.Enums.Gender;
import com.covid19.Enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotEmpty(message = "Name is mandatory")
	@Size(min = 3, max = 20, message = "Name length should be of size 3-20")
	private String Name;
	
	@Email
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
//	@Size(min=6, max=20)
//	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
		
	@Past
	private LocalDate DateOfBirth ;
	
	@NotNull(message = "Gender can't be null")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotEmpty(message =  "Address is mandatory")
	private String Address ;
	
	@NotEmpty(message =  "City is mandatory")
	@Size(min = 2, max = 30 , message = "City length should be of size 3-20")
	private String city ;
	
	@NotEmpty(message =  "Pincode is mandatory")
	@Size(min = 5, max = 6 , message = "Pincode length should be of size 5-6")
	private String pincode ;
	
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


/*
*
{
  "name": "Rohit",
  "email": "Rohit@gmail.com",
  "password": "12345",
  "role": "ROLE_ADMIN",
  "dateOfBirth": "1990-01-01",
  "gender": "Male",
  "address": "123 Street",
  "city": "New York",
  "pincode": "12345",
  "state": "New York"
}

* */










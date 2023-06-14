package com.covid19.Models;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	private boolean dose1;
	
	private boolean dose2;
	
	private LocalDate dose1date;
	
	private LocalDate dose2date;
//	@Email
//	@NotEmpty(message = "Email cannot be empty")
//	private String email;
//	
//	@Size(min=6, max=20)
//	@NotEmpty(message = "Password cannot be empty")
//	private String password;
	
//	private 
//	@Size(min=6, max=20)
//	@NotEmpty(message = "ConfirmPassword cannot be empty")
//	private String confirmPassword;
	
	@OneToOne(mappedBy = "member" , cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	@OneToOne(mappedBy = "member" , cascade = CascadeType.ALL)
	private IdCard idcard;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

}
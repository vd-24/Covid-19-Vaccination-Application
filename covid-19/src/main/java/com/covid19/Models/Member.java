package com.covid19.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	@Email
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@Size(min=6, max=20)
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@Size(min=6, max=20)
	@NotEmpty(message = "ConfirmPassword cannot be empty")
	private String confirmPassword;
}
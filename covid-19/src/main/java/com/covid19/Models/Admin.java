package com.covid19.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	@Size(max = 20, min = 2)
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@NotEmpty(message = "Phone cannot be empty")
	private String contactNumber;
	
	@Email
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	
	@Size(max=20, min=6)
	@NotEmpty(message = "Password cannot be empty")
	private String password;
	
	@Size(max=20, min=6)
	@NotEmpty(message = "ConfirmPassword cannot be empty")
	private String confirmPassword;
}
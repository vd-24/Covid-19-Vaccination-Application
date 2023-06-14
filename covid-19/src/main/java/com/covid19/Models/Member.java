package com.covid19.Models;

import com.covid19.Enums.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	private boolean dose1 = false;
	private boolean dose2 = false;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dose1Date;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dose2Date;

	@OneToOne(cascade = CascadeType.ALL)

	private Vaccine vaccine_Id;

	private Role role;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

}
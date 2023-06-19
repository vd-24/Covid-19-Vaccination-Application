package com.covid19.Models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer memberId;
	
	private boolean dose1;
	
	private boolean dose2;
	
	private LocalDate dose1date;
	
	private LocalDate dose2date;
	
	@OneToOne(mappedBy = "member" , cascade = CascadeType.ALL)
	private Vaccine vaccine;
	@JsonIgnore
	@OneToOne(mappedBy = "member" , cascade = CascadeType.ALL)
	private IdCard idcard;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Appointment appointment;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

}
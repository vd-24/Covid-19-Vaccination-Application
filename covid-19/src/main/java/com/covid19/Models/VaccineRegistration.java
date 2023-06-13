package com.covid19.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity

public class VaccineRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Integer regId;
	
	private String mobileno;
	
	private LocalDate dateofregistration;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "vaccineRegistration",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Member> members = new ArrayList<>();
}
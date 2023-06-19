package com.covid19.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data             
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCenter {
	@Id           
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer centerCode;
	
	private String name;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonProperty(access =  JsonProperty.Access.WRITE_ONLY)
	private VaccineInventory inventory;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Appointment appointment;



}
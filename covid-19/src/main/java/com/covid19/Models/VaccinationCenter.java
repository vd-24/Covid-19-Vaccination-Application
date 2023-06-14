package com.covid19.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data             
//Generate all getter setter+constructor +to string automatically.(Not Working);
public class VaccinationCenter {
	
	
	@Id           
	@GeneratedValue(strategy = GenerationType.AUTO)   
	private Integer centerCode;
	
	
	private String name;
	

	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)   
	// One Vaccination center can have only one Inventory.
  @NotNull
	private VaccineInventory inventory;
	
	
	@OneToMany    
	//// One Vaccination center can have many Appointment.
	@JsonIgnore
	List<Appointment> appointments = new ArrayList<>();
}
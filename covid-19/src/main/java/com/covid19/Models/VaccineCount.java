package com.covid19.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class VaccineCount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countid;
	@OneToOne
	private Vaccine vaccine;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore   // @JsonIgnoreProperties ignores the specified logical properties in JSON serialization and deserialization
	private VaccineInventory inventory;
	
	private Integer inId;
	
	private Integer quantity;
}
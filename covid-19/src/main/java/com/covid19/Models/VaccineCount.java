package com.covid19.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineCount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countid;
	
	private double price;
	private Integer quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore   
	private VaccineInventory inventory;
	
	
}
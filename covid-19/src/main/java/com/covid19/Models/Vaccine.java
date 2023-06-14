package com.covid19.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineId;
	
	private String vaccineName;
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Member member;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineCount vaccineCount;
	
}
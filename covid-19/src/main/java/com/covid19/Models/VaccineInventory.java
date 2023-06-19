package com.covid19.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccineInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer inventoryId;
    
	private LocalDate date;
	
	@OneToMany(mappedBy = "vaccineInventory",cascade = CascadeType.ALL)
	private List<VaccineCount> vaccineCounts = new ArrayList<>();

	@OneToOne(mappedBy = "inventory",cascade = CascadeType.ALL)
	private VaccinationCenter vaccinationCenter;

	public void addVaccineCount(VaccineCount count){
		this.vaccineCounts.add(count);
		count.setVaccineInventory(this);
	}


}
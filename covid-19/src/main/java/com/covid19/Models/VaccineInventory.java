package com.covid19.Models;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<VaccineCount> vaccineCount;
	
	
	
}
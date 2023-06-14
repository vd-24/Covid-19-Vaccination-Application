package com.covid19.Models;

import jakarta.persistence.*;

@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vaccineId;
	private String vaccineName;
	private String description;

	@OneToOne(mappedBy = "vaccine_Id",cascade = CascadeType.ALL)
	@JoinTable(name = "Vaccine Id")
	private Member member;

}
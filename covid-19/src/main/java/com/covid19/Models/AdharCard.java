package com.covid19.Models;

import com.covid19.Enums.Fingerprint;
import com.covid19.Enums.IrisScan;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdharCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adharId;
	
	@Pattern( regexp = "^[0-9]{12}",message = "the number should be 12 digit")
	@Column(unique = true)
	private String adharNo;
	
	@NotNull(message = "Fingerprint can be null")
	@NotEmpty(message = "Fingerprint can't be empty")
	@NotBlank(message = "Fingerprint can't be blank")
	@Enumerated(EnumType.STRING)
	private Fingerprint fingerprints;
	
	
	@NotNull(message = "irisscan can be null")
	@NotEmpty(message = "irisscan can't be empty")
	@NotBlank(message = "irisscan can't be blank")
	@Enumerated(EnumType.STRING)
	private IrisScan irisscan;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "adharCard")
	@JsonIgnore
	private IdCard idCard;
}
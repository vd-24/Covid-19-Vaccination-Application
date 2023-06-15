package com.covid19.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer panId;
	
	@NotNull(message = "panNo should not be null")
	@NotBlank(message = "panNo should not be blank")
	@NotEmpty(message = "panNo should not be Empty")
	@Size(min = 10, max = 10, message = "{user.invalid.panNumber}")
	@Column(unique = true)
	private String panNo;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "panCard")
	@JsonIgnore
	private IdCard idCard;
}
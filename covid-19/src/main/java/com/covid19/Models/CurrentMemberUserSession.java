package com.covid19.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CurrentMemberUserSession {
	
	@Id
	private Integer memberId;
	
	@Column(unique = true)
	private String uuid;
	
	private LocalDateTime loginTime;
}
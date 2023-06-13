package com.covid19.Models;

import javax.management.relation.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class User {
	
	public String email;
	public String password;
	
	@Enumerated(EnumType.STRING)
	public Role role;
}
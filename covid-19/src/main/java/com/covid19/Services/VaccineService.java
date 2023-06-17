package com.covid19.Services;

import java.util.List;

import com.covid19.Models.Vaccine;

public interface VaccineService {

	public Vaccine addVaccine(Vaccine vaccine);
	public Vaccine updateVaccine(Vaccine vaccine);
	public boolean deleteVaccine(Integer vaccineId);
	public Vaccine getVaccineByName(String VaccineName);
	public Vaccine getVaccineById(int vaccineId);
	public List<Vaccine> getAllVaccine();
	
}


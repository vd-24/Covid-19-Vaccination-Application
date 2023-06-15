package com.covid19.Service;

import com.covid19.Models.Vaccine;

public interface VaccineService {

	public void addVaccine(Vaccine vaccine);
	public Vaccine updateVaccine(Vaccine vaccine);
	public boolean deleteVaccine(Vaccine vaccine);
	public Vaccine getVaccineByName(String VaccineName);
	public Vaccine getVaccineById(int vaccineId);
	
}


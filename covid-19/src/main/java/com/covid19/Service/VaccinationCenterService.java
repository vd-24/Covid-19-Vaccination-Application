package com.covid19.Service;

import java.util.List;

import com.covid19.Models.VaccinationCenter;

public interface VaccinationCenterService {
	
	public List<VaccinationCenter> getAllVaccinationCenters();
	public VaccinationCenter getVaccinationCenterById(Integer centerId);
	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter);
	public VaccinationCenter updateVaccinationCenter(Integer centerId,VaccinationCenter vaccinationCenter);
	public boolean deleteVaccineCenter(Integer centerId);
	
}

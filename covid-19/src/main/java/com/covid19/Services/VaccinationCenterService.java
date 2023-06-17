package com.covid19.Services;

import java.util.List;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Models.VaccinationCenter;

public interface VaccinationCenterService {
	
	public List<VaccinationCenter> getAllVaccinationCenters() throws VaccinationCenterException;
	public VaccinationCenter getVaccinationCenterById(Integer centerId) throws VaccinationCenterException;
	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationCenterException;
	public VaccinationCenter updateVaccinationCenter(Integer centerId,VaccinationCenter vaccinationCenter) throws VaccinationCenterException;
	public boolean deleteVaccineCenter(Integer centerId) throws VaccinationCenterException;
	
}

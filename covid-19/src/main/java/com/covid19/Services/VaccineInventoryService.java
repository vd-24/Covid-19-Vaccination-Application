package com.covid19.Services;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Exception.VaccineInventoryException;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;

public interface VaccineInventoryService {
	public VaccineCount addVaccineCount(String key,Integer inId,Vaccine v,Integer qty) throws LoginException,VaccineInventoryException; 
	public List<VaccineInventory> getInventoryByDate(String key,LocalDate date)throws LoginException;
	public VaccineInventory addInventory(String key,VaccineInventory inventory)throws LoginException,VaccinationCenterException;
	public VaccineInventory getInventoryByVaccinationCenter(String key,Integer id) throws LoginException,VaccinationCenterException;
	public List<VaccineCount> getVaccineCountByCenter(String key,VaccineInventory in)throws LoginException,VaccineInventoryException;
	public List<VaccineInventory> getAllVaccineInventories(String key) throws LoginException;
}
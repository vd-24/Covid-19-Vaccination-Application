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
	public VaccineInventory addVaccineCount(Integer inId,Vaccine v,Integer qty) throws VaccineInventoryException;
	public List<VaccineInventory> getInventoryByDate(LocalDate date) throws VaccineInventoryException;
	public VaccineInventory addInventory(VaccineInventory inventory);
	public VaccineInventory getInventoryByVaccinationCenter(Integer id) throws VaccinationCenterException;
	public List<VaccineCount> getVaccineCountByCenter(Integer id) throws VaccinationCenterException;
	public List<VaccineInventory> getAllVaccineInventories() throws VaccineInventoryException;
	public VaccineInventory updateInventory(Integer inventoryId, VaccineInventory inventory) throws VaccineInventoryException;
	public boolean deleteInventory(Integer id) throws VaccineInventoryException;
}
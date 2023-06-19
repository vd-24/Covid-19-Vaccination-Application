package com.covid19.Services;

import java.time.LocalDate;
import java.util.List;

import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;

public interface VaccineInventoryService {

	public VaccineInventory addVaccineCount(Integer inId,Vaccine v,Integer qty); 
	public List<VaccineInventory> getInventoryByDate(LocalDate date);
	public VaccineInventory addInventory(VaccineInventory inventory);
	public VaccineInventory getInventoryByVaccinationCenter(Integer id);
	public List<VaccineCount> getVaccineCountByCenter(Integer id);
	public List<VaccineInventory> getAllVaccineInventories();
	public VaccineInventory updateInventory(Integer inventoryId, VaccineInventory inventory);
	public boolean deleteInventory(Integer id);
}
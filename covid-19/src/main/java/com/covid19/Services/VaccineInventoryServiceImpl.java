package com.covid19.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Exception.VaccineCountException;
import com.covid19.Exception.VaccineInventoryException;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;
import com.covid19.Repository.VaccinationCenterRepository;
import com.covid19.Repository.VaccineInventoryRepository;

@Service
public class VaccineInventoryServiceImpl implements VaccineInventoryService{

	@Autowired
	VaccineInventoryRepository inventoryRepo;
	
	@Autowired
	VaccinationCenterRepository centerRepo;
	
	@Override

	public VaccineInventory addVaccineCount(Integer inId, Vaccine v, Integer qty) {

		Optional<VaccineInventory> opt = inventoryRepo.findById(inId);
		if(opt.isEmpty()) throw new VaccineInventoryException("No VaccineInventory found");
		
		VaccineInventory inventory = opt.get();
		
		List<VaccineCount> list = inventory.getVaccineCounts();
		if(list.isEmpty()) throw new VaccineCountException("No Vaccine Present");
		
		VaccineCount vc = null;
		
		for(VaccineCount i : list) {
			if(i.getVaccine().getVaccineId()==v.getVaccineId()) {
				i.setQuantity(i.getQuantity()+qty);
				vc=i;
				break;
			}
		}
		return inventoryRepo.save(inventory);
		
	}

	@Override

	public List<VaccineInventory> getInventoryByDate(LocalDate date) {
		List<VaccineInventory> list = inventoryRepo.findByDate(date);
		if(list.isEmpty())throw new VaccineInventoryException("No Vaccine Inventory Present");
		return list;
	}

	@Override
	public VaccineInventory addInventory(VaccineInventory inventory) {
		VaccineInventory vi = inventoryRepo.save(inventory);
		
		return vi;
	}

	@Override

	public VaccineInventory getInventoryByVaccinationCenter(Integer id) {
		Optional<VaccinationCenter> opt = centerRepo.findById(id);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Center Present of This id");
		
		VaccinationCenter center = opt.get();
		
		VaccineInventory vi = center.getInventory();
		
		
		return vi;
	}

	@Override

	public List<VaccineCount> getVaccineCountByCenter(Integer centerId) {
		Optional<VaccinationCenter> opt = centerRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Center Present of This id");
		
		VaccinationCenter center = opt.get();
		
		List<VaccineCount> list = center.getInventory().getVaccineCounts();
		return list;
	}

	@Override
	public List<VaccineInventory> getAllVaccineInventories() {
		List<VaccineInventory> list = inventoryRepo.findAll();
		if(list.isEmpty()) throw new VaccineInventoryException("No Inventory Present");
		return list;
	}

	@Override

	public VaccineInventory updateInventory(Integer inventoryId, VaccineInventory inventory) {
		Optional<VaccineInventory> opt = inventoryRepo.findById(inventoryId);
		if(opt.isEmpty()) throw new VaccineInventoryException("No Inventory Found By This ID");
		
		VaccineInventory oldInventory = opt.get();
		oldInventory.setDate(inventory.getDate());
		List<VaccineCount> list = oldInventory.getVaccineCounts();
		if(!list.isEmpty()) {
			oldInventory.getVaccineCounts().addAll(list);

		}
		return oldInventory;
	}

	@Override

	public boolean deleteInventory(Integer id) {
		Optional<VaccineInventory> opt = inventoryRepo.findById(id);
		if(opt.isEmpty()) throw new VaccineInventoryException("No Inventory Found");
		
		if(opt.get()==null) return false;
		
		inventoryRepo.delete(opt.get());
		return true;
	}

	
}

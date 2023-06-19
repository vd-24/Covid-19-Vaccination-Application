package com.covid19.Services;

import java.util.List;
import java.util.Optional;

import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;
import com.covid19.Repository.VaccineCountRepository;
import com.covid19.Repository.VaccineInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Repository.VaccinationCenterRepository;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	VaccinationCenterRepository vaccinationCenterRepo;
	@Autowired
	VaccineCountRepository vaccineCountRepository;
	@Autowired
	VaccineInventoryRepository vaccineInventoryRepository;
	
	@Override

	public List<VaccinationCenter> getAllVaccinationCenters() {
		List<VaccinationCenter> list = vaccinationCenterRepo.findAll();
		if(list.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		return list;
	}

	@Override

	public VaccinationCenter getVaccinationCenterById(Integer centerId) {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		
		return opt.get();
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(vaccinationCenter.getCenterCode());
		if (opt.isPresent()) {
			throw new VaccinationCenterException("Vaccination Center Already Present");
		}

		return vaccinationCenterRepo.save(vaccinationCenter);
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(Integer centerId,VaccinationCenter vaccinationCenter) {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");




		return vaccinationCenterRepo.save(vaccinationCenter);
	}

	@Override
	public boolean deleteVaccineCenter(Integer centerId) {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		
		vaccinationCenterRepo.delete(opt.get());
		return true;
	}

}

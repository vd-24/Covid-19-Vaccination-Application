package com.covid19.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Repository.VaccinationCenterRepository;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService{

	@Autowired
	VaccinationCenterRepository vaccinationCenterRepo;
	
	@Override
	public List<VaccinationCenter> getAllVaccinationCenters() throws VaccinationCenterException {
		List<VaccinationCenter> list = vaccinationCenterRepo.findAll();
		if(list.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		return list;
	}

	@Override
	public VaccinationCenter getVaccinationCenterById(Integer centerId) throws VaccinationCenterException {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		
		return opt.get();
	}

	@Override
	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationCenterException {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(vaccinationCenter.getCenterCode());
		if(opt.isPresent()) throw new VaccinationCenterException("Vaccination Center Already Present");
		
		return vaccinationCenterRepo.save(vaccinationCenter);
	}

	@Override
	public VaccinationCenter updateVaccinationCenter(Integer centerId,VaccinationCenter vaccinationCenter) throws VaccinationCenterException {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		
		VaccinationCenter oldCenter = opt.get();
		oldCenter.setAddress(vaccinationCenter.getAddress());
		oldCenter.setName(vaccinationCenter.getName());
	
		return vaccinationCenterRepo.save(oldCenter);
	}

	@Override
	public boolean deleteVaccineCenter(Integer centerId) throws VaccinationCenterException {
		Optional<VaccinationCenter> opt = vaccinationCenterRepo.findById(centerId);
		if(opt.isEmpty()) throw new VaccinationCenterException("No Vaccination Center Found");
		
		vaccinationCenterRepo.delete(opt.get());
		return true;
	}

}

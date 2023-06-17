package com.covid19.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Models.Vaccine;
import com.covid19.Repository.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    public Vaccine addVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    public Vaccine updateVaccine(Vaccine vaccine) {
        Vaccine existingVaccine = vaccineRepository.findById(vaccine.getVaccineId()).orElse(null);
        if (existingVaccine != null) {
            return vaccineRepository.save(vaccine);
        }
        return null;
    }

    public boolean deleteVaccine(Integer vaccineId) {
        Vaccine existingVaccine = vaccineRepository.findById(vaccineId).orElse(null);
        if (existingVaccine != null) {
            vaccineRepository.delete(existingVaccine);
            return true;
        }
        return false;
    }

    
    public Vaccine getVaccineById(int vaccineId) {
        return vaccineRepository.findById(vaccineId).orElse(null);
    }

    public Vaccine getVaccineByName(String vaccineName) {
        return vaccineRepository.findByName(vaccineName);
    }

	@Override
	public List<Vaccine> getAllVaccine() {
		List<Vaccine> list = vaccineRepository.findAll();
		return list;
	}

}


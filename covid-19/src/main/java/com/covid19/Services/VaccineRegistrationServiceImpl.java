package com.covid19.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid19.Models.Member;
import com.covid19.Models.VaccineRegistration;
import com.covid19.Repository.VaccineRegistrationRepository;

public class VaccineRegistrationServiceImpl implements VaccineRegistrationService {
	
	private final VaccineRegistrationRepository vaccineRegistrationRepository;
	
	@Autowired
	public VaccineRegistrationServiceImpl(VaccineRegistrationRepository vaccineRegistrationRepository) {
		this.vaccineRegistrationRepository = vaccineRegistrationRepository;
	}

	@Override
	public List<VaccineRegistration> allVaccineRegistrations() {
		return vaccineRegistrationRepository.findAll();
	}

	@Override
	public VaccineRegistration getVaccineRegistration(String mobileNumber) {
		VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobileNumber(mobileNumber);
		return vaccineRegistration ;
	}

	@Override
	public List<Member> getAllMember(String mobileNumber) {
		VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobileNumber(mobileNumber);
		return vaccineRegistration.getMembers();
	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) {
		
		return vaccineRegistrationRepository.save(vaccineRegistration);
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration) {
		
		return null;
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration vaccineRegistration) {
		vaccineRegistrationRepository.delete(vaccineRegistration);
		return true;
	}

}

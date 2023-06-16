package com.covid19.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.covid19.Exception.VaccineRegistrationException;
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
		List<VaccineRegistration> list = vaccineRegistrationRepository.findAll();
		if(list.isEmpty()) throw new VaccineRegistrationException("No Vaccine Registered");
		return list;
	}

	@Override
	public VaccineRegistration getVaccineRegistration(String mobileNumber) {
		VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobileNumber(mobileNumber);
		if(vaccineRegistration == null) throw new VaccineRegistrationException("No Vaccine Registered with this number");
		return vaccineRegistration ;
	}

	@Override
	public List<Member> getAllMember(String mobileNumber) {
		VaccineRegistration vaccineRegistration = vaccineRegistrationRepository.findByMobileNumber(mobileNumber);
		if(vaccineRegistration.getMembers().isEmpty()) throw new VaccineRegistrationException("No Member Registered");
		return vaccineRegistration.getMembers();
	}

	@Override
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration) {
		return vaccineRegistrationRepository.save(vaccineRegistration);
	}

	@Override
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration) {
		return vaccineRegistrationRepository.save(vaccineRegistration);
	}

	@Override
	public boolean deleteVaccineRegistration(VaccineRegistration vaccineRegistration) {
		vaccineRegistrationRepository.delete(vaccineRegistration);
		return true;
	}

}

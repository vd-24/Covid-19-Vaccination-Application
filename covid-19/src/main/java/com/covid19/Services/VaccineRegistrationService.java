package com.covid19.Services;

import java.util.List;

import com.covid19.Models.Member;
import com.covid19.Models.VaccineRegistration;

public interface VaccineRegistrationService {
	
	public List<VaccineRegistration> allVaccineRegistrations();
	public VaccineRegistration getVaccineRegistration(String mobileNumber);
	public List<Member> getAllMember(String mobileNumber);
	public VaccineRegistration addVaccineRegistration(VaccineRegistration vaccineRegistration);
	public VaccineRegistration updateVaccineRegistration(VaccineRegistration vaccineRegistration);
	public boolean deleteVaccineRegistration(VaccineRegistration vaccineRegistration);
	
	
}

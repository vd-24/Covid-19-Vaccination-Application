package com.covid19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.Exception.MemberException;
import com.covid19.Models.IdCard;
import com.covid19.Models.Member;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineRegistration;
import com.covid19.Services.AppointmentService;
import com.covid19.Services.IdCardService;
import com.covid19.Services.MemberService;
import com.covid19.Services.VaccinationCenterService;
import com.covid19.Services.VaccineInventoryService;
import com.covid19.Services.VaccineRegistrationService;
import com.covid19.Services.VaccineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IdCardService idCardService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MemberService memberService;
    
    @Autowired
    VaccinationCenterService centerService;
    
    @Autowired
    VaccineService vaccineService;

    @Autowired
    VaccineRegistrationService vaccineRegistrationService;
    
//    @Autowired
//    VaccineInventoryService vaccineInventoryService;
    
    @Autowired
    AppointmentService appointmentService;
    
    
//-----------Sign In ------------
    
    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details

        IdCard customer= idCardService.getMemberByEmail(auth.getName());

        return new ResponseEntity<>(customer.getEmail()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/hello")
    public String testHandler() {
        return "Welcome to Spring Security";
    }
    
    
    //Member methods starts
    
    @PostMapping("/register")
    public ResponseEntity<IdCard> registerMember(@RequestBody @Valid IdCard idCard){

        idCard.setPassword(passwordEncoder.encode(idCard.getPassword()));

        return new ResponseEntity<>(idCardService.registerNewMember(idCard),HttpStatus.CREATED);
    }

   
    @GetMapping("/members")
	public ResponseEntity<List<IdCard>> getAllMembers(){

		List<IdCard> members = idCardService.getAllMembers();
		
		return new ResponseEntity<List<IdCard>>(members, HttpStatus.OK);

	}
    

	@GetMapping(value = "/members/{memberId}")
	public ResponseEntity<IdCard> getMemberById(@PathVariable("memberId") Integer memberId) {

		IdCard member = memberService.findMemberById(memberId);

		return new ResponseEntity<IdCard>(member, HttpStatus.OK);
	}

	@GetMapping("/memberbyaadhar/{aadhar}")
	public ResponseEntity<IdCard> getMemberByAadharNo(@PathVariable("aadhar") String aadharNo) {

		IdCard member = memberService.findMemberByAadharCard(aadharNo);

		return new ResponseEntity<IdCard>(member, HttpStatus.OK);

	}

	@GetMapping("/membersbypan/{pan}")
	public ResponseEntity<IdCard> getMemberByPanNo(@PathVariable("pan") String panNo){

		IdCard member = memberService.findMemberByPanCard(panNo);

		
		return new ResponseEntity<IdCard>(member, HttpStatus.OK);

	}

	

	@PutMapping("/members/{memberId}")
	public ResponseEntity<IdCard> updateMember(@RequestBody @Valid Member member,@PathVariable Integer memberId) {

		IdCard updatedMember = memberService.updateMember(member,memberId);
		
		return new ResponseEntity<IdCard>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping("/members/{memberId}")
	public ResponseEntity<String> deleteMember(@PathVariable Integer memberId){

		String ans = memberService.deleteMember(memberId);

		return new ResponseEntity<String>(ans, HttpStatus.OK);

	}

	//member methods ends
	
	//Vaccination Center Methods Starts
	
	@GetMapping("/getVaccineCenters")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccineCenters(){

		List<VaccinationCenter> allvaclist = centerService.getAllVaccinationCenters();

		return new ResponseEntity<>(allvaclist,HttpStatus.OK);
	}

	@GetMapping("/getVaccinationCenter/{centerId}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable("centerId") Integer centerId){

		VaccinationCenter vc = centerService.getVaccinationCenterById(centerId);

		return new ResponseEntity<>(vc,HttpStatus.OK);
	}

	@PostMapping("/addVaccinationCenter")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody @Valid VaccinationCenter center){

		VaccinationCenter vc = centerService.addVaccinationCenter(center);
		
		return new ResponseEntity<>(vc,HttpStatus.ACCEPTED);

	}

	@PutMapping("/updateVaccinationCenter/{centerId}")
	public ResponseEntity<VaccinationCenter> updateVaccinationCenter(@RequestBody @Valid VaccinationCenter center,@PathVariable Integer centerId) {

		VaccinationCenter vc = centerService.updateVaccinationCenter(centerId,center);
		
		return new ResponseEntity<>(vc,HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/deleteVaccinationCenter/{centerId}")
	public ResponseEntity<Boolean> deleteVaccinationCenter(@PathVariable Integer centerId) {

		boolean flag = centerService.deleteVaccineCenter(centerId);
		return new ResponseEntity<>(flag,HttpStatus.ACCEPTED);
	}

	// vaccination center methods ends
	
	// vaccine methods starts here
	
	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccine(){

		List<Vaccine> vaccines = vaccineService.getAllVaccine();

		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine")
	public ResponseEntity<Vaccine> getVaccineByName(@RequestParam String vaccineName){
		String temp = vaccineName.toLowerCase();
		Vaccine vaccines = vaccineService.getVaccineByName(temp);

		return new ResponseEntity<>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable("vaccineId") Integer vaccineId){

		Vaccine vaccine = vaccineService.getVaccineById(vaccineId);

		return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
	}

	@PostMapping("/vaccines")
	public ResponseEntity<Vaccine> addVaccine(@RequestBody @Valid Vaccine vaccine){

		Vaccine vacc = vaccineService.addVaccine(vaccine);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.CREATED);
	}

	@PutMapping("/vaccines")
	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody @Valid Vaccine vaccine) {

		Vaccine vacc = vaccineService.updateVaccine(vaccine);

		return new ResponseEntity<Vaccine>(vacc, HttpStatus.OK);
	}

	@DeleteMapping("/vaccines/{vaccineId}")
	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable("vaccineId") Integer vaccineId) {

		Boolean ans = vaccineService.deleteVaccine(vaccineId);

		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
	}

	// Vaccine Methods Ends Here
	
	
	//Id Card Methods Starts
	
	@GetMapping("/Idcard")
	public ResponseEntity<IdCard> getPanCardByNumber(@RequestParam String panNumber){
		IdCard id = idCardService.getPanCardByNumber(panNumber);
		return new ResponseEntity<IdCard>(id,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/IdCard")
	public ResponseEntity<IdCard> getIdCardByAadharNumber(@RequestParam String aadharNumber){
		IdCard id = idCardService.getAdharCardByNo(aadharNumber);
		return new ResponseEntity<IdCard>(id,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addIdCard")
	public ResponseEntity<IdCard> addIdCard(@Valid @RequestBody IdCard idCard){
		IdCard id = idCardService.addIdCard(idCard);
		return new ResponseEntity<IdCard>(id,HttpStatus.ACCEPTED);
	}
	
	// id Card Ends here
	
//		Vaccine Registratin Methods starts here
	
	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable("moblineno") String mobileno) {

		VaccineRegistration vaccineRegistration = vaccineRegistrationService.getVaccineRegistration(mobileno);

		return new ResponseEntity<VaccineRegistration>(vaccineRegistration, HttpStatus.OK);

	}

	@PutMapping("/vaccineUpdate")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistration(@RequestBody @Valid VaccineRegistration vaccineRegistration){

		VaccineRegistration updateVR = vaccineRegistrationService.updateVaccineRegistration(vaccineRegistration);

		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/vaccineRegistration/{registrationNo}")
	public ResponseEntity<Boolean> deleteVaccineRegistrationHandler(@PathVariable("registrationNo") Integer registrationNo){
		Boolean deleteVR = vaccineRegistrationService.deleteVaccineRegistration(registrationNo);

		return new ResponseEntity<Boolean>(deleteVR, HttpStatus.OK);
	}
	
	@GetMapping("/getMembersByMobileNumber")
	public ResponseEntity<List<Member>> getAllMembers(@RequestParam String mobileNumber){
		List<Member> list = vaccineRegistrationService.getAllMember(mobileNumber);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	// vaccine Registration methods ends
	
	// Appointment Method Starts here
	
	
	
}

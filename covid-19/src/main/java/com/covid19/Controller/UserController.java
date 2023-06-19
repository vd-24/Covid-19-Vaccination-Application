package com.covid19.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.covid19.Models.Appointment;
import com.covid19.Models.IdCard;
import com.covid19.Models.Member;
import com.covid19.Models.VaccinationCenter;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineRegistration;
import com.covid19.Services.AppointmentService;
import com.covid19.Services.IdCardService;
import com.covid19.Services.MemberService;
import com.covid19.Services.VaccinationCenterService;
import com.covid19.Services.VaccineRegistrationService;
import com.covid19.Services.VaccineService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private VaccineRegistrationService vrService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private VaccineService vaccineService;

	@Autowired
	private VaccinationCenterService centerService;

	@Autowired
	private IdCardService iCardService;


	@Autowired
	private AppointmentService appointmentService;

	

//	@GetMapping("/members")
//	public ResponseEntity<List<Member>> getAllMembers(){
//
//		List<Member> members = memberService.fi;
//
//		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
//
//	}

	 @GetMapping("/signIn")
	    public ResponseEntity<IdCard> getLoggedInCustomerDetailsHandler(Authentication auth){

	        System.out.println(auth); // this Authentication object having Principle object details

	        IdCard customer= iCardService.getMemberByEmail(auth.getName());

	        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	    }
	
	@GetMapping("/members/{memberId}")
	public ResponseEntity<IdCard> getMemberById(@PathVariable Integer memberId) {

		IdCard member = memberService.findMemberById(memberId);

		return new ResponseEntity<>(member, HttpStatus.OK);

	}

	@GetMapping("/membersbyaadhar/{aadhar}")
	public ResponseEntity<IdCard> getMemberByAadharNo(@PathVariable String aadharNo) {

		IdCard member = memberService.findMemberByAadharCard(aadharNo);

		return new ResponseEntity<IdCard>(member, HttpStatus.OK);

	}

	@GetMapping("/membersbypan/{pan}")
	public ResponseEntity<IdCard> getMemberByPanNo(@PathVariable("pan") String panNo) {

		IdCard member = memberService.findMemberByAadharCard(panNo);

		return new ResponseEntity<IdCard>(member, HttpStatus.OK);

	}

//	@PostMapping(value = "/members")
//	public ResponseEntity<Member> addMember(@RequestBody @Valid Member member) {
//
//		Member addedMember = memberService.addMember(member);
//
//		return new ResponseEntity<Member>(addedMember, HttpStatus.OK);
//
//	}

	@PutMapping("/members/{memberId}")
	public ResponseEntity<IdCard> updateMember(@RequestBody @Valid Member member,@PathVariable Integer memberId){

		IdCard updatedMember = memberService.updateMember(member, memberId);

		return new ResponseEntity<IdCard>(updatedMember, HttpStatus.OK);

	}

	@DeleteMapping("/members/{memberId}")
	public ResponseEntity<String> deleteMember(@PathVariable Integer memberId) {

		String ans = memberService.deleteMember(memberId);

		return new ResponseEntity<>(ans, HttpStatus.OK);

	}

	// user can perform vaccine registration crud operation


	@PostMapping("/addvaccineRegistration")
	public ResponseEntity<VaccineRegistration> addVaccineRegistrationr(@RequestBody @Valid VaccineRegistration regs) {
		VaccineRegistration addVaccineRegistration = vrService.addVaccineRegistration(regs);
		return new ResponseEntity<VaccineRegistration>(addVaccineRegistration, HttpStatus.OK);
	}

	@GetMapping("/vaccineRegistration/{moblineno}")
	public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable String mobileno) {

		VaccineRegistration vaccineRegistration = vrService.getVaccineRegistration(mobileno);

		return new ResponseEntity<VaccineRegistration>(vaccineRegistration, HttpStatus.OK);

	}

	@PutMapping("/vaccineRegisrations")
	public ResponseEntity<VaccineRegistration> updateVaccineRegistration(
			@RequestBody @Valid VaccineRegistration vaccineRegistration) {

		VaccineRegistration updateVR = vrService.updateVaccineRegistration(vaccineRegistration);

		return new ResponseEntity<VaccineRegistration>(updateVR, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/vaccineRegistration/{registrationNo}")
	public ResponseEntity<Boolean> deleteVaccineRegistration(@PathVariable Integer registrationNo) {
		Boolean deleteVR = vrService.deleteVaccineRegistration(registrationNo);

		return new ResponseEntity<Boolean>(deleteVR, HttpStatus.OK);
	}

	// user can perform vaccine crud operation

	@GetMapping("/vaccines")
	public ResponseEntity<List<Vaccine>> allVaccine() {
		List<Vaccine> vaccines = vaccineService.getAllVaccine();
		return new ResponseEntity<List<Vaccine>>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine")
	public ResponseEntity<Vaccine> getVaccineByName(@RequestParam String vaccineName) {

		Vaccine vaccines = vaccineService.getVaccineByName(vaccineName);

		return new ResponseEntity<Vaccine>(vaccines, HttpStatus.OK);
	}

	@GetMapping("/vaccine/{vaccineId}")
	public ResponseEntity<Vaccine> getVaccineById(@PathVariable Integer vaccineId){

		Vaccine vaccine = vaccineService.getVaccineById(vaccineId);

		return new ResponseEntity<Vaccine>(vaccine, HttpStatus.OK);
	}

//	@PostMapping("/vaccines")
//	public ResponseEntity<Vaccine> addVaccineController(@RequestBody Vaccine vaccine, Integer vaccineInventoryId,
//			@RequestParam(required = false) String key) throws VaccineException, LoginException {
//
//		Vaccine vacc = vaccineService.addVaccine(vaccine, vaccineInventoryId, key);
//
//		return new ResponseEntity<Vaccine>(vacc, HttpStatus.CREATED);
//	}
//
//	@PutMapping("/vaccines")
//	public ResponseEntity<Vaccine> updateVaccineController(@RequestBody Vaccine vaccine,
//			@RequestParam(required = false) String key) throws VaccineException, LoginException {
//
//		Vaccine vacc = vaccineService.updateVaccine(vaccine, key);
//
//		return new ResponseEntity<Vaccine>(vacc, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/vaccines/{vaccineId}")
//	public ResponseEntity<Boolean> deleteVaccineController(@PathVariable Integer vaccineId){
//
//		Boolean ans = vaccineService.deleteVaccine(vaccineId);
//
//		return new ResponseEntity<Boolean>(ans, HttpStatus.OK);
//	}

	// user vaccine center access
	@GetMapping("/getVaccineCenter")
	public ResponseEntity<List<VaccinationCenter>> getAllVaccineCenters() {
		List<VaccinationCenter> allvaclist = centerService.getAllVaccinationCenters();

		return new ResponseEntity<List<VaccinationCenter>>(allvaclist,HttpStatus.OK);
	}

	@GetMapping("/getVaccineCenter/{centerId}")
	public ResponseEntity<VaccinationCenter> getVaccineCenter(@PathVariable Integer centerId) {
		VaccinationCenter vc = centerService.getVaccinationCenterById(centerId);


		return new ResponseEntity<>(vc,HttpStatus.OK);
	}

	@GetMapping("/panNo")
	public ResponseEntity<IdCard> getPanCardByNumber(@RequestParam String panNo) {
		IdCard idcard = iCardService.getPanCardByNumber(panNo);
		return new ResponseEntity<IdCard>(idcard, HttpStatus.OK);

	}

	@GetMapping("/adharNo")
	public ResponseEntity<IdCard> getAdharCardByNo(@RequestParam String adharNo) {
		IdCard idcard = iCardService.getAdharCardByNo(adharNo);

		return new ResponseEntity<IdCard>(idcard, HttpStatus.OK);

	}

	@PostMapping("/idcard")
	public ResponseEntity<IdCard> addIdCard(@RequestBody @Valid IdCard idCard) {

		IdCard idcard = iCardService.addIdCard(idCard);

		return new ResponseEntity<IdCard>(idcard, HttpStatus.CREATED);

	}


	// Appointment method

	@GetMapping("/appointments/vaccinationCenterId/{vaccinationCenterId}")
	public ResponseEntity<Appointment> getAllAppoinmentsByVaccineCenterId(
			@PathVariable Integer vaccinationCenterId){

		Appointment appnintmentList = appointmentService.getAppointmentById(vaccinationCenterId);

		return new ResponseEntity<Appointment>(appnintmentList, HttpStatus.OK);
	}

	@GetMapping("/appointments/{bookingid}")
	public ResponseEntity<Appointment> getAppoinment(@PathVariable("bookingid") Integer bookingId) {

		Appointment appointment = appointmentService.getAppointmentById(bookingId);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);

	}

	@PostMapping("/appointments/{memberId}/{centerId}")
	public ResponseEntity<Appointment> addAppoinment(@RequestBody @Valid Appointment app,@PathVariable Integer memberId, @PathVariable Integer centerId) {


		Appointment appointment = appointmentService.addAppointment(memberId, app, centerId);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@PutMapping("/appointments/{appId}")
	public ResponseEntity<Appointment> updateAppoinment(@RequestBody @Valid Appointment app, @PathVariable Integer appId){

		Appointment appointment = appointmentService.updateAppointment(appId, app);

		return new ResponseEntity<Appointment>(appointment, HttpStatus.OK);
	}

	@DeleteMapping("/appointments/{appointmentId}")
	public ResponseEntity<Boolean> deleteAppoinment(@PathVariable Integer appointmentId){
		
		Boolean result = appointmentService.deleteAppointment(appointmentId);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}
}


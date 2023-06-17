package com.covid19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.Models.Member;
import com.covid19.Models.VaccineRegistration;
import com.covid19.Services.VaccineRegistrationService;

@RestController
@RequestMapping("/registration")
public class VaccineRegistrationController {
	
	public final VaccineRegistrationService vaccineRegistrationService;
	
	@Autowired
	public VaccineRegistrationController(VaccineRegistrationService vaccineRegistrationService) {
		this.vaccineRegistrationService = vaccineRegistrationService;
	}
	
	@GetMapping
	public ResponseEntity<List<VaccineRegistration>> getAllVaccineRegistrations(){
		List<VaccineRegistration> list = vaccineRegistrationService.allVaccineRegistrations();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{mobileNumber}")
    public ResponseEntity<VaccineRegistration> getVaccineRegistration(@PathVariable String mobileNumber) {
        VaccineRegistration vaccineRegistration = vaccineRegistrationService.getVaccineRegistration(mobileNumber);
        return new ResponseEntity<>(vaccineRegistration,HttpStatus.OK);
    }

    @GetMapping("/{mobileNumber}/members")
    public ResponseEntity<List<Member>> getAllMembers(@PathVariable String mobileNumber) {
        List<Member> members = vaccineRegistrationService.getAllMember(mobileNumber);
        return new ResponseEntity<>(members,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VaccineRegistration> addVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) {
        VaccineRegistration createdVaccineRegistration = vaccineRegistrationService.addVaccineRegistration(vaccineRegistration);
        return new ResponseEntity<>(createdVaccineRegistration,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<VaccineRegistration> updateVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) {
        VaccineRegistration updatedVaccineRegistration = vaccineRegistrationService.updateVaccineRegistration(vaccineRegistration);
        return new ResponseEntity<>(updatedVaccineRegistration,HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVaccineRegistration(@RequestBody VaccineRegistration vaccineRegistration) {
        boolean deleted = vaccineRegistrationService.deleteVaccineRegistration(vaccineRegistration);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

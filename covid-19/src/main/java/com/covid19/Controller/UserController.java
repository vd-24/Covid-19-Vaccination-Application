package com.covid19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.covid19.Models.Vaccine;
import com.covid19.Services.VaccineService;

@RestController
@RequestMapping("/vaccines")
public class UserController {

    @Autowired
    VaccineService vaccineService;
   

    @PostMapping
    public ResponseEntity<Vaccine> addVaccine(@RequestBody Vaccine vaccine) {
        Vaccine createdVaccine = vaccineService.addVaccine(vaccine);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVaccine);
    }

    @PutMapping
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine) {
        Vaccine updatedVaccine = vaccineService.updateVaccine(vaccine);
        if (updatedVaccine != null) {
            return ResponseEntity.ok(updatedVaccine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVaccine(@RequestBody Vaccine vaccine) {
        boolean deleted = vaccineService.deleteVaccine(vaccine);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaccine> getVaccineById(@PathVariable("id") Integer id) {
        Vaccine vaccine = vaccineService.getVaccineById(id);
        if (vaccine != null) {
            return ResponseEntity.ok(vaccine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Vaccine> getVaccineByName(@RequestParam("name") String vaccineName) {
        Vaccine vaccine = vaccineService.getVaccineByName(vaccineName);
        if (vaccine != null) {
            return ResponseEntity.ok(vaccine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


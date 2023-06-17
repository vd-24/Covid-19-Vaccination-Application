package com.covid19.Controller;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Exception.VaccineInventoryException;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;
import com.covid19.Services.VaccineInventoryService;

import lombok.Data;

@RestController
@RequestMapping("/vaccine-inventory")
public class VaccineInventoryController {

    private VaccineInventoryService vaccineInventoryService;

    @Autowired
    public VaccineInventoryController(VaccineInventoryService vaccineInventoryService) {
        this.vaccineInventoryService = vaccineInventoryService;
    }

    @PostMapping("/add-vaccine-count")
    public ResponseEntity<VaccineCount> addVaccineCount(@RequestBody VaccineCountRequest vaccineCountRequest) {
        try {
            VaccineCount vaccineCount = vaccineInventoryService.addVaccineCount(vaccineCountRequest.getKey(),
                    vaccineCountRequest.getInId(), vaccineCountRequest.getVaccine(), vaccineCountRequest.getQty());
            return ResponseEntity.ok(vaccineCount);
        } catch (LoginException | VaccineInventoryException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/get-inventory-by-date")
    public ResponseEntity<List<VaccineInventory>> getInventoryByDate(@RequestParam String key,
            @RequestParam LocalDate date) {
        try {
            List<VaccineInventory> inventories = vaccineInventoryService.getInventoryByDate(key, date);
            return ResponseEntity.ok(inventories);
        } catch (LoginException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/add-inventory")
    public ResponseEntity<VaccineInventory> addInventory(@RequestBody VaccineInventory inventory) {
        try {
            VaccineInventory addedInventory = vaccineInventoryService.addInventory(inventory.getKey(), inventory);
            return ResponseEntity.ok(addedInventory);
        } catch (LoginException | VaccinationCenterException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/get-inventory-by-vaccination-center")
    public ResponseEntity<VaccineInventory> getInventoryByVaccinationCenter(@RequestParam String key,
            @RequestParam Integer id) {
        try {
            VaccineInventory inventory = vaccineInventoryService.getInventoryByVaccinationCenter(key, id);
            return ResponseEntity.ok(inventory);
        } catch (LoginException | VaccinationCenterException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/get-vaccine-count-by-center")
    public ResponseEntity<List<VaccineCount>> getVaccineCountByCenter(@RequestParam String key,
            @RequestBody VaccineInventory inventory) {
        try {
            List<VaccineCount> vaccineCounts = vaccineInventoryService.getVaccineCountByCenter(key, inventory);
            return ResponseEntity.ok(vaccineCounts);
        } catch (LoginException | VaccineInventoryException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/get-all-vaccine-inventories")
    public ResponseEntity<List<VaccineInventory>> getAllVaccineInventories(@RequestParam String key) {
        try {
            List<VaccineInventory> inventories = vaccineInventoryService.getAllVaccineInventories(key);
            return ResponseEntity.ok(inventories);
        } catch (LoginException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

@Data
    public static class VaccineCountRequest {
             private String key;
        private Integer inId;
        private Vaccine vaccine;
        private Integer qty;

        
    }
}


package com.covid19.Services;

import java.time.LocalDate;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.covid19.Exception.VaccinationCenterException;
import com.covid19.Exception.VaccineInventoryException;
import com.covid19.Models.Vaccine;
import com.covid19.Models.VaccineCount;
import com.covid19.Models.VaccineInventory;
import com.covid19.Repository.VaccineInventoryRepository;

@Service
@Transactional
public class VaccineInventoryServiceImpl implements VaccineInventoryService {

    private VaccineInventoryRepository vaccineInventoryRepository;

    @Autowired
    public VaccineInventoryServiceImpl(VaccineInventoryRepository vaccineInventoryRepository) {
        this.vaccineInventoryRepository = vaccineInventoryRepository;
    }


@Override
@Secured("ROLE_ADMIN")
public VaccineCount addVaccineCount(String key, Integer inId, Vaccine v, Integer qty) throws LoginException, VaccineInventoryException {
    
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }
    
   
    String username = authentication.getUsername();
    
    
    
   
    VaccineInventory inventory = vaccineInventoryRepository.findById(inId)
            .orElseThrow(() -> new VaccineInventoryException("Vaccine inventory not found"));
    
  
    VaccineCount vaccineCount = new VaccineCount();
    vaccineCount.setVaccine(v);
    vaccineCount.setQuantity(qty);
    vaccineCount.setInventory(inventory);
    
  
    vaccineInventoryRepository.save(vaccineCount);
    
    return vaccineCount;
}

@Override
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public List<VaccineInventory> getInventoryByDate(String key, LocalDate date) throws LoginException {
   
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }
    
  
    String username = authentication.getUsername();
    
  
    List<VaccineInventory> inventories = vaccineInventoryRepository.findByDate(date);
    
    return inventories;
}

@Override
@Secured("ROLE_ADMIN")
public VaccineInventory addInventory(String key, VaccineInventory inventory) throws LoginException, VaccinationCenterException {
  
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }
    
   
    String username = authentication.getUsername();
    
   
    VaccineInventory addedInventory = vaccineInventoryRepository.save(inventory);
    
    return addedInventory;
}

@Override
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public VaccineInventory getInventoryByVaccinationCenter(String key, Integer id) throws LoginException, VaccinationCenterException {
    
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }
    

    String username = authentication.getName();
    
  
    VaccineInventory inventory = vaccineInventoryRepository.findById(id)
            .orElseThrow(() -> new VaccinationCenterException("Vaccine inventory not found for the given vaccination center ID"));
    
    return inventory;
}

@Override
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public List<VaccineCount> getVaccineCountByCenter(String key, VaccineInventory in) throws LoginException, VaccineInventoryException {
    
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }
    
    String username = authentication.getName();
    
    List<VaccineCount> vaccineCounts = in.getVaccineCount();
    
    return vaccineCounts;
}


@Override
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public List<VaccineInventory> getAllVaccineInventories(String key) throws LoginException {
   
    Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.isAuthenticated()) {
        throw new LoginException("User not authenticated");
    }

    String username = authentication.getName();
 
    List<VaccineInventory> inventories = vaccineInventoryRepository.findAll();
    
    return inventories;
}
}

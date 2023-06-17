package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid19.Models.VaccineRegistration;

@Repository
public interface VaccineRegistrationRepository extends JpaRepository<VaccineRegistration, Integer>,PagingAndSortingRepository<VaccineRegistration, Integer>{
    public  VaccineRegistration findByMobileno(String mobileNumber);
}

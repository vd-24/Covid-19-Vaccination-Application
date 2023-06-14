package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid19.Models.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

}

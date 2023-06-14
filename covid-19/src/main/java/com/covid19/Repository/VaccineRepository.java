package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid19.Models.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer>,PagingAndSortingRepository<Vaccine, Integer>{

}

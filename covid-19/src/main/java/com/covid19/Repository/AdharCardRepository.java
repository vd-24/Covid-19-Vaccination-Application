package com.covid19.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid19.Models.AdharCard;

public interface AdharCardRepository extends JpaRepository<AdharCard, Integer>{
	
	public Optional<AdharCard> findByAdharNo(String adharNo);
}

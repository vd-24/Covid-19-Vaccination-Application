package com.covid19.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid19.Models.AdharCard;

@Repository
public interface AdharCardRepository extends JpaRepository<AdharCard, Integer>,PagingAndSortingRepository<AdharCard, Integer>{
	public Optional<AdharCard> findByAdharNo(String adharNo);
}

package com.covid19.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid19.Models.PanCard;

@Repository
public interface PanCardRepository extends JpaRepository<PanCard, Integer>,PagingAndSortingRepository<PanCard, Integer>{
	public Optional<PanCard> findByPanNo(String panNumber);
}

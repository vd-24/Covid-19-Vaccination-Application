package com.covid19.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid19.Models.PanCard;

public interface PanCardRepository extends JpaRepository<PanCard, Integer>{
	public Optional<PanCard> findByPanNo(String panNumber);
}

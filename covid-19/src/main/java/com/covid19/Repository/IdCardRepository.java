package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid19.Models.IdCard;

public interface IdCardRepository extends JpaRepository<IdCard, Integer>{

}

package com.covid19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.covid19.Models.IdCard;

import java.util.Optional;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer>,PagingAndSortingRepository<IdCard, Integer>{

    Optional<IdCard> findByEmail(String email);
}

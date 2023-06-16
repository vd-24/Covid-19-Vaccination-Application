package com.covid19.Repository;

import com.covid19.Exception.AadharCardException;
import com.covid19.Exception.PanCardException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid19.Models.IdCard;

import java.util.Optional;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Integer>,PagingAndSortingRepository<IdCard, Integer>{

    Optional<IdCard> findByEmail(String email);

    @Query("select i from IdCard i Inner join i.adharCard a where a.adharNo = :s")
    public Optional<IdCard> findByAadharCardNumber(@Param("s") String s)throws AadharCardException;

    @Query("select i from IdCard i Inner Join i.panCard p where p.panNo = :panNo")
    public Optional<IdCard> findByPanCardNumber(@Param("panNo") String panNO)throws PanCardException;

}

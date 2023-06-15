package com.covid19.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid19.Exception.IdCardException;
import com.covid19.Models.AdharCard;
import com.covid19.Models.IdCard;
import com.covid19.Models.PanCard;
import com.covid19.Repository.AdharCardRepository;
import com.covid19.Repository.IdCardRepository;
import com.covid19.Repository.PanCardRepository;

@Service
public class IdCardServiceImpl implements IdCardService{

	@Autowired
	AdharCardRepository adharRepo;
	
	@Autowired
	PanCardRepository panRepo;
	
	@Autowired
	IdCardRepository idCardRepo;
	
	
	@Override
	public IdCard getPanCardByNumber(String panNumber) {
		Optional<PanCard> p= panRepo.findByPanNo(panNumber);
		if(p.isEmpty()) throw new IdCardException("No Pan Card Found");
		
		PanCard pan = p.get();
		IdCard icard = pan.getIdCard();
		if(icard==null) throw new IdCardException("No Id Card Found");
		
		return icard;
	}

	
	@Override
	public IdCard getAdharCardByNo(String adharNo) {
		Optional<AdharCard> p = adharRepo.findByAdharNo(adharNo);
		if(p.isEmpty()) throw new IdCardException("No Adhar Card Found");
		
		AdharCard adhar = p.get();
		IdCard icard = adhar.getIdCard();
		if(icard==null) throw new IdCardException("No Id Card Found");
		
		return icard;
	}

	@Override
	public IdCard addIdCard(IdCard idCard) {
		Optional<IdCard> opt = idCardRepo.findById(idCard.getId());
		if(opt.isPresent()) throw new IdCardException("Id card already present");
		
		return idCardRepo.save(idCard);
	}
	
}

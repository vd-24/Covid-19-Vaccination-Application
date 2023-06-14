package com.covid19.Service;

import com.covid19.Models.IdCard;

public interface IdCardService {
	
	public IdCard getPanCardByNumber(String panNumber);
	public IdCard getAdharCardByNo(String adharNo);
	public IdCard addIdCard(IdCard idCard);
}

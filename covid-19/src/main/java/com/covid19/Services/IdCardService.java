package com.covid19.Services;

import java.util.List;

import com.covid19.Models.IdCard;


public interface IdCardService {

    public IdCard registerNewMember(IdCard member);
    public List<IdCard> getAllMembers();
    public IdCard getMemberByEmail(String email);
	public IdCard getPanCardByNumber(String panNumber);
	public IdCard getAdharCardByNo(String adharNo);
	public IdCard addIdCard(IdCard idCard);
}

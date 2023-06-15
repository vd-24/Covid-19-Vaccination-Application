package com.covid19.Services;

import com.covid19.Models.IdCard;
import com.covid19.Models.Member;

import java.util.List;

public interface IdCardService {

    public IdCard registerNewMember(IdCard member);
    public List<IdCard> getAllMembers();
    public IdCard getMemberByEmail(String email);

}

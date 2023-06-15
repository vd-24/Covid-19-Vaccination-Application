package com.covid19.Services;

import com.covid19.Exception.MemberException;
import com.covid19.Models.IdCard;
import com.covid19.Models.Member;

public interface MemberService {

    public IdCard findMemberById(Integer id)throws MemberException;
    public IdCard findMemberByAadharCard(String aadharNo)throws MemberException;
    public IdCard findMemberByPanCard(String panNo)throws MemberException;
    public IdCard updateMember(Member member,Integer memberId)throws MemberException;
    public String deleteMember(Integer memberId)throws MemberException;

}

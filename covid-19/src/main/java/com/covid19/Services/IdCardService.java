package com.covid19.Services;

import com.covid19.Models.Member;

import java.util.List;

public interface MemberService {

    public Member registerNewMember(Member member);
    public List<Member> getAllMembers();
    public Member getMemberByEmail(String email);

}

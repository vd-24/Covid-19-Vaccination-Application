package com.covid19.Service;

import java.util.*;
import com.covid19.Models.Member;

public interface MemberService {

    public Member registerNewMember(Member member);
    public List<Member> getAllMembers();
    public Member getMemberByEmail(String email);

}

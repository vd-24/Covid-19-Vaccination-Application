package com.covid19.Services;

import com.covid19.Models.Member;
import com.covid19.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;


    @Override
    public Member registerNewMember(Member member) {

       Member member1 =  memberRepository.save(member);
        return member1;
    }

    @Override
    public List<Member> getAllMembers() {

        List<Member> members = memberRepository.findAll();

        return members;
    }

    @Override
    public Member getMemberByEmail(String email) {

        Optional<Member> member = memberRepository.findByEmail(email);
        return member.get();
    }
}

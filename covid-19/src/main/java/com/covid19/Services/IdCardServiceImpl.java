package com.covid19.Services;

import com.covid19.Models.IdCard;
import com.covid19.Models.Member;
import com.covid19.Repository.IdCardRepository;
import com.covid19.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdCardServiceImpl implements IdCardService {

    @Autowired
    IdCardRepository idCardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public IdCard registerNewMember(IdCard member) {
//        memberRepository.save(member.getMember());
//
       IdCard member1 =  idCardRepository.save(member);

        return member1;
    }



    @Override
    public List<IdCard> getAllMembers() {

        List<IdCard> members = idCardRepository.findAll();

        return members;
    }

    @Override
    public IdCard getMemberByEmail(String email) {

        Optional<IdCard> member = idCardRepository.findByEmail(email);
        return member.get();
    }
}

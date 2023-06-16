package com.covid19.Services;

import com.covid19.Exception.MemberException;
import com.covid19.Models.IdCard;
import com.covid19.Models.Member;
import com.covid19.Repository.IdCardRepository;
import com.covid19.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public IdCard findMemberById(Integer id) throws MemberException {
        Optional<IdCard> idCard = idCardRepository.findById(id);

        if(idCard.isPresent()){
            return idCard.get();
        }else{
            throw new MemberException("Member Not Found With Id:- "+id);
        }

    }

    @Override
    public IdCard findMemberByAadharCard(String aadharNo) throws MemberException {

        Optional<IdCard> idCard = idCardRepository.findByAadharCardNumber(aadharNo);

        if(idCard.isPresent()){
            return idCard.get();
        }else{
            throw new MemberException("Member Not Found With Id:- "+aadharNo);
        }
    }

    @Override
    public IdCard findMemberByPanCard(String panNo) throws MemberException {
        Optional<IdCard> idCard = idCardRepository.findByPanCardNumber(panNo);

        if(idCard.isPresent()){
            return idCard.get();
        }else{
            throw new MemberException("Member Not Found With Id:- "+panNo);
        }
    }

    @Override
    public IdCard updateMember(Member member, Integer memberId) throws MemberException {
        Optional<Member> idCard = memberRepository.findById(memberId);

        if(idCard.isPresent()){
          IdCard idCard1 =   idCardRepository.save(idCard.get().getIdcard());
          Member member1 =   memberRepository.save(member);
            return idCard1;
        }else{
            throw new MemberException("Member Not Found With Id:- "+memberId);
        }
    }

    @Override
    public String deleteMember(Integer memberId) throws MemberException {
        Optional<IdCard> idCard = idCardRepository.findById(memberId);

        if(idCard.isPresent()){

            idCardRepository.deleteById(memberId);
            memberRepository.deleteById(idCard.get().getMember().getMemberId());

            return "done.......";
        }else{
            throw new MemberException("Member Not Found With Id:- "+memberId);
        }
    }
}

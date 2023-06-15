package com.covid19.Service;

import com.covid19.Models.Member;
import com.covid19.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;
import java.util.Optional;

public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> opt= memberRepository.findByEmail(username);

        if(opt.isPresent()) {

            Member customer= opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();

            SimpleGrantedAuthority sga= new SimpleGrantedAuthority(customer.getRole().toString());

            authorities.add(sga);

            return new User(customer.getEmail(), customer.getPassword(), authorities);

        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);
    }

}

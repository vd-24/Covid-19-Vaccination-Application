package com.covid19.Services;

import com.covid19.Models.IdCard;
import com.covid19.Models.Member;
import com.covid19.Repository.IdCardRepository;
import com.covid19.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    IdCardRepository idCardRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<IdCard> id = idCardRepository.findByEmail(username);

        if(id.isPresent()) {

            IdCard idCard = id.get();
            List<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority(idCard.getRole().toString());
            authorities.add(sga);
            return new User(idCard.getEmail(), idCard.getPassword(), authorities);

        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);
    }

}

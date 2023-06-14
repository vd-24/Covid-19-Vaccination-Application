package com.covid19.Controller;

import com.covid19.Models.Member;
import com.covid19.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details

        Member customer= memberService.getMemberByEmail(auth.getName());

        return new ResponseEntity<>(customer.getEmail()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }

}

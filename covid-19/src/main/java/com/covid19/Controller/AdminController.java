package com.covid19.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid19.Models.IdCard;
import com.covid19.Services.IdCardService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    IdCardService idCardService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<IdCard> registerMember(@RequestBody IdCard idCard){

        idCard.setPassword(passwordEncoder.encode(idCard.getPassword()));

        return new ResponseEntity<>(idCardService.registerNewMember(idCard),HttpStatus.CREATED);
    }

    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth); // this Authentication object having Principle object details

        IdCard customer= idCardService.getMemberByEmail(auth.getName());

        return new ResponseEntity<>(customer.getEmail()+"Logged In Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/hello")
    public String testHandler() {
        return "Welcome to Spring Security";
    }

}

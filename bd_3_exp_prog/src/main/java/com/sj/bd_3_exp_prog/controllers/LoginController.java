package com.sj.bd_3_exp_prog.controllers;

import com.sj.bd_3_exp_prog.entities.AppUser;
import com.sj.bd_3_exp_prog.services.AppUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AppUserService appUserService;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(){

        return "pages/loginPage";

    }

    @GetMapping("/loading")
    public String loading(){

        return "pages/loadingPage";

    }

    //Need to create a custom filter, this is not correct
//    @PostMapping("/authenticate")
//    public void authenticateUser(
//        @RequestParam("email") String email,
//        @RequestParam("password") String password){
//        System.err.println("Custom authentication!");
//
//        Optional<AppUser> optionalAppUser = Optional.ofNullable(appUserService.findByEmail(email));
//        AppUser appUser = optionalAppUser.orElseThrow(() -> new BadCredentialsException("Invalid email and/or password."));
//
//        UsernamePasswordAuthenticationToken authToken =
//                new UsernamePasswordAuthenticationToken(
//                        appUser,
//                        password,
//                        appUser.getAuthorities()
//                );
//
//        try {
//
//            Authentication authentication = authenticationManager.authenticate(authToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        } catch (AuthenticationException e) {
//
//            throw new BadCredentialsException("Invalid email and/or password.");
//
//        }
//    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }
}
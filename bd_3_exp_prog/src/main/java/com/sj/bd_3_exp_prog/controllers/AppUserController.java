package com.sj.bd_3_exp_prog.controllers;

import com.sj.bd_3_exp_prog.entities.AppUser;
import com.sj.bd_3_exp_prog.services.AppUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppUserController {

    @Autowired
    private AppUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public String createUser(
            @Valid AppUser newAppUser,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){

        if(userService.findByEmail(newAppUser.getEmail()) != null){
            bindingResult.rejectValue("email", "error.appUser", "Email already exists");
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.getFlashAttributes().clear();
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.appUser", bindingResult);
            redirectAttributes.addFlashAttribute("appUser", newAppUser);
            return "redirect:/register";
        }

        newAppUser.setPassword(passwordEncoder.encode(newAppUser.getPassword()));
        userService.createUser(newAppUser);
        return "redirect:/login";
    }

    @GetMapping("/profile/{email:.+}")
    public String userProfile(
            @PathVariable String email,
            Model model,
            HttpServletRequest request){

        HttpSession session = request.getSession();
        Authentication authentication = (Authentication) session.getAttribute("authentication");
        AppUser foundAppUser = userService.findByEmail(email);

        model.addAttribute("appUser", foundAppUser);
        model.addAttribute("authentication", authentication);
        return "pages/profilePage";

    }

}

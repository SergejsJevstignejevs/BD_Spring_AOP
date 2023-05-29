package com.sj.bd_3_exp_prog.controllers;

import com.sj.bd_3_exp_prog.entities.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping
    public String userRegistrationForm(Model model) {
        if(!model.containsAttribute("appUser")){
            model.addAttribute("appUser", new AppUser());
        }
        return "pages/registerPage";
    }


}

package com.sj.bd_3_exp_prog.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        Authentication authentication = (Authentication) session.getAttribute("authentication");
        model.addAttribute("authentication", authentication);
        return "pages/mainPage";

    }

}

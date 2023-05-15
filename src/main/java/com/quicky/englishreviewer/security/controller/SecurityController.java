package com.quicky.englishreviewer.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/authentication")
@Controller
public class SecurityController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/welcome-home")
    public String welcomePage(ModelMap model){
        model.put("userId","you");
        return "welcome";
    }
    @GetMapping("/login=error")
    public String failLogin(ModelMap model){
        model.put("param.error","true");
        return"login";
    }
    @GetMapping("/logout")
    public String logout(ModelMap model){
        model.put("param.logout","true");
        return "login";
    }

}

package com.quicky.englishreviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/authentication")
@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login-check")
    public String welcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){
        if(username.equals("admin")&&password.equals("root")){
            model.put("userId",username);
            return "welcome";
        }
        model.put("param.error","true");
        return "login";
    }
    @GetMapping("/authentication/login?error")
    public String failLogin(ModelMap model){
        model.put("param.error","true");
        return"login";
    }
    @GetMapping("/authentication/logout")
    public String logout(ModelMap model){
        model.put("param.logout","true");
        return "login";
    }

}

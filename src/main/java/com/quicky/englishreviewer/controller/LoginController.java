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

    @PostMapping("/login")
    public String welcomePage(ModelMap model, @RequestParam String userId, @RequestParam String password){
        if(userId.equals("admin")&&password.equals("root")){
            model.put("userId",userId);
            return "welcome";
        }
        model.put("errorMsg","please provide the correct user and password");
        return "login";
    }
    @GetMapping("/authentication/login?error")
    public String failLogin(ModelMap model){
        model.put("errorMsg","Something errors, please login again!");
        return"login";
    }

}

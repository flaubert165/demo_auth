package com.example.demo_auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StarterController {

    @RequestMapping("/")
    public String loadIndex(){
        return "index";
    }

}

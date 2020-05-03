package com.pks.coronavirustracker.controllers;

//controller helps to show the URLS to have UI like use HTML
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //put things in the model and acess it here and show it in the home.html

    @GetMapping("/")
    public String home(Model model){
        //mnow this model is accesable in home.html
        model.addAttribute("TestName","NAME");

        return "home";
    }
}

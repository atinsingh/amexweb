package co.pragra.amexweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControl {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title","Our First Application");
        model.addAttribute("author","Pragra");
        return "index";
    }
}

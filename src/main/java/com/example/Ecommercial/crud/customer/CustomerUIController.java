package com.example.Ecommercial.crud.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerUIController {


    @RequestMapping("/login")
    public String customerUI(){
        return "home";
    }
}

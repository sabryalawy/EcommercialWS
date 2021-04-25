package com.example.Ecommercial.crud.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerUIController {


    @GetMapping("/customerui")
    public String customerUI(){
        return "UI/customerUI/customerui";
    }
}

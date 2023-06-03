package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rental")
public class RentalController {
    @RequestMapping("/list")
    public String rentalList() {
        return "rental/rentalList";
    }

    @RequestMapping("/write")
    public String rentalWrite() {
        return "rental/rentalWrite";
    }

    @RequestMapping("/form")
    public String rentalRegistrationForm() {
        return "rental/rentalRegistrationForm";
    }
}

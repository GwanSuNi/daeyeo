package com.daeyeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RentalController {
    @RequestMapping("/rental_list")
    public String rentalList() {
        return "rental/rentalList";
    }

    @RequestMapping("/rental_write_form")
    public String rentalWriteForm() {
        return "rental/rentalWriteForm";
    }
}

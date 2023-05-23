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

    @RequestMapping("/writeForm")
    public String rentalWriteForm() {
        return "rental/rentalWriteForm";
    }
}

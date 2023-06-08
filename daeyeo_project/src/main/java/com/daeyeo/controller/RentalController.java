package com.daeyeo.controller;

import com.daeyeo.command.RentalObjectDTO;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.service.RentalObjectService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rental")
public class RentalController {
    RentalObjectService rentalObjectService;

    @RequestMapping("/list")
    public String rentalList() {
        return "rental/rentalList";
    }

    @RequestMapping("/write")
    public String rentalWrite() {
        return "rental/rentalWrite";
    }

    @RequestMapping("/form")
    public String rentalRegistrationForm(RentalObjectDTO rentalObjectDTO , Model model) {
        String representNum = rentalObjectDTO.getRepresentNum1();
        representNum = rentalObjectDTO.getRepresentNum2()+rentalObjectDTO.getRepresentNum3();

        rentalObjectService.insertRentalObjectReal(rentalObjectDTO.getScId(),rentalObjectDTO.getOwnerEmail()
                ,rentalObjectDTO.getObjectName(),rentalObjectDTO.getLocationInfo(),rentalObjectDTO.getAddress(),
                rentalObjectDTO.getPrice(),rentalObjectDTO.getReceiptStartDuration(),rentalObjectDTO.getReceiptEndDuration(),
                rentalObjectDTO.getStartDuration(),rentalObjectDTO.getEndDuration(),representNum);
        return "rental/rentalRegistrationForm";
    }
}

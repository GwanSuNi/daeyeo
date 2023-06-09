package com.daeyeo.controller;

import com.daeyeo.command.RentalListCmd;
import com.daeyeo.command.RentalObjectDTO;
import com.daeyeo.entity.MainCategory;
import com.daeyeo.entity.RentalObject;
import com.daeyeo.entity.SubCategory;
import com.daeyeo.service.MainCategoryService;
import com.daeyeo.service.RentalObjectService;
import com.daeyeo.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    MainCategoryService mainCategoryService;
    @Autowired
    SubCategoryService subCategoryService;
    @Autowired
    RentalObjectService rentalObjectService;

    @RequestMapping("/list")
    public String rentalList(RentalListCmd rentalListCmd, Model model) {
        List<SubCategory> subCategories = subCategoryService.findByMcId(rentalListCmd.getMainCate());
        List<String> list;

        if(rentalListCmd.getMainCate().equals(""))
            list = mainCategoryService.getAllCategories().stream().map(MainCategory::getMcId).collect(Collectors.toList());
        else if (subCategories == null)
            list = new ArrayList<>();
        else
            list = subCategories.stream().map(SubCategory::getScId).collect(Collectors.toList());

        model.addAttribute("categories", list);
        System.out.println("==========================================");
        model.addAttribute("rentalList", rentalObjectService.findRentalObjectByCommand(rentalListCmd));

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

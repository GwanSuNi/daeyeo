package com.daeyeo.helloDaeyeo.controller;

import com.daeyeo.helloDaeyeo.dto.rental.RentalObjectDto;
import com.daeyeo.helloDaeyeo.dto.rental.RentalRegisterDto;
import com.daeyeo.helloDaeyeo.dto.rental.SearchSpecDto;
import com.daeyeo.helloDaeyeo.service.MemberService;
import com.daeyeo.helloDaeyeo.service.RentalObjectService;
import com.daeyeo.helloDaeyeo.service.SubCategoryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("rentals")
public class RentalController {
    private final SubCategoryService subCategoryService;
    private final RentalObjectService rentalObjectService;
    private final MemberService memberService;

    // TODO: 지금은 db에서 데이터들을 다 가져온다음 페이징을 하는 데 db에서 페이징을 한 데이터들을 가져오는 걸로 바꿔야 함
    @GetMapping({"list", "list/{page}"})
    public String rentalList(SearchSpecDto specDto, @PathVariable(required = false) Integer page, Model model) {
        if (page == null)
            page = 1;

        Pageable pageable = PageRequest.of(page - 1, 9);

        List<String> categories = subCategoryService.getCategories(specDto.getMainCategory());
        Page<RentalObjectDto> rentalObjectDtos = rentalObjectService.findListBySearchSpec(specDto, pageable);

        model.addAttribute("categories", categories);
        model.addAttribute("searchSpec", specDto);
        model.addAttribute("rentalObjects", rentalObjectDtos);

        return "rental/rentalList";
    }

    @RequestMapping("write/{objectId}")
    public String rentalWrite(@PathVariable long objectId, Model model) {
        model.addAttribute("rentalObject", rentalObjectService.getRentalObject(objectId));

        return "rental/rentalWrite";
    }

    @GetMapping("register")
    public String showRentalRegistrationForm(HttpServletRequest request, Model model) {
        memberService.validateMember(request);
        model.addAttribute("registerDto", new RentalRegisterDto());

        return "rental/rentalRegistrationForm";
    }

    @RequestMapping("register.do")
    public String register(@Valid RentalRegisterDto dto, HttpServletRequest request) {
        memberService.validateMember(request);
        rentalObjectService.insertRentalObject(dto);

        return "redirect:/rentals/list";
    }
    /*
    @RequestMapping("/rental.do")
    public String rental(@RequestParam int objectId, @RequestParam String startDuration, @RequestParam String endDuration, @RequestParam int price, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        UserEntity loginUser = (UserEntity) session.getAttribute("loginUser");
        String send = "redirect:/rental/list";

        if (loginUser == null)
            send = "redirect:/login";
        else
            rentalLogService.insertRentalLog(objectId, loginUser.getUserEmail(), LocalDate.parse(startDuration), LocalDate.parse(endDuration), price);

        return send;
    }
     */
}
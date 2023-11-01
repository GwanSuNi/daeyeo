package com.daeyeo.helloDaeyeo.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("errors")
public class ErrorController {
    @GetMapping("403")
    public String error403() {
        return "error/403";
    }

    @GetMapping("404")
    public String error404() {
        return "error/404";
    }
}

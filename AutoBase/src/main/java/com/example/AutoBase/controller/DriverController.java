package com.example.AutoBase.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {

    @Value("${value.title}")
    private String pageTitle;

    @GetMapping(value = {"/userInfo"})
    public String loginPage(Model model) {
        model.addAttribute("title", pageTitle);
        return "userInfo";
    }
}

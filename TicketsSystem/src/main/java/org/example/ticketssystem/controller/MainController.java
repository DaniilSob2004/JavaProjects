package org.example.ticketssystem.controller;

import org.example.ticketssystem.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String welcomePage(Model model) {
        return "main";
    }
}

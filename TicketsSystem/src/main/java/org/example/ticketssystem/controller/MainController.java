package org.example.ticketssystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/", "/welcome"})
    public String welcomePage(Model model) {
        return "main";
    }
}

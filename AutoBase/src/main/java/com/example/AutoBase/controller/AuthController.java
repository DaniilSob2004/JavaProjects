package com.example.AutoBase.controller;

import com.example.AutoBase.dto.MessageDto;
import com.example.AutoBase.model.Driver;
import com.example.AutoBase.service.registrationuserservice.RegistrationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

@Controller
@Transactional
public class AuthController {

    @Value("${value.title}")
    private String pageTitle;

    @Value("${value.alertTextColorError}")
    private String alertTextColorError;

    @Value("${value.alertTextColorSuccess}")
    private String alertTextColorSuccess;

    @Autowired
    private RegistrationUserService registrationUserService;


    @GetMapping(value = {"/login"})
    public String loginPage(Model model) {
        return "auth/login";
    }

    @GetMapping(value = "/registration")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new Driver());
        return "auth/registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute Driver driver, BindingResult bindingResult, Model model) {
        System.out.println(driver);

        MessageDto messageDto = new MessageDto();
        messageDto.setColor(alertTextColorError);

        if (bindingResult.hasErrors()) {
            messageDto.setMessage("Binding results error");
            model.addAttribute("message", messageDto);
            model.addAttribute("userForm", driver);
            return "auth/registration";
        }
        if (!driver.getEncryptedPassword().equals(driver.getPasswordConfirm())) {
            messageDto.setMessage("Passwords don't match");
            model.addAttribute("message", messageDto);
            model.addAttribute("userForm", driver);
            return "auth/registration";
        }
        if (!registrationUserService.registerUser(driver)) {
            messageDto.setMessage("A user with the same name already exists");
            model.addAttribute("message", messageDto);
            model.addAttribute("userForm", driver);
            return "auth/registration";
        }

        return "redirect:/userInfo";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logout(Model model, RedirectAttributes redirectAttributes) {
        MessageDto messageDto = new MessageDto("Logout Successful!", alertTextColorSuccess);
        redirectAttributes.addFlashAttribute("message", messageDto);
        return "redirect:/main";
    }
}

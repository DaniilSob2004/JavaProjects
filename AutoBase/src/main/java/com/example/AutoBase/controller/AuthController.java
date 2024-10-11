package com.example.AutoBase.controller;

import com.example.AutoBase.dto.MessageDto;
import com.example.AutoBase.service.busines.driverservice.DriverService;
import com.example.AutoBase.service.busines.roleservice.RoleService;
import com.example.AutoBase.service.busines.userroleservice.UserRoleService;
import com.example.AutoBase.service.securityservice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private DriverService driverService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping(value = {"/login"})
    public String loginPage(Model model) {
        return "auth/login";
    }

    /*@GetMapping(value = "/registration")
    public String registrationPage(Model model) {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestParam("name") String name,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("phone") String phone,
                               Model model) {
        // шифруем пароль и добалвяем пользователя
        String encPassword = passwordEncoder.encode(password);
        Customer addCustomer = new Customer(0, name, email, phone, encPassword, null);
        Customer customer = customerService.save(addCustomer);

        // добавляем роль
        Role userRole = roleService.findRoleByName("ROLE_USER").orElse(null);
        if (userRole == null) {
            throw new RuntimeException("Role not found...");
        }

        // связка роли и пользователя
        CustomerRole customerRole = new CustomerRole(0, customer, userRole);
        customerRoleService.save(customerRole);

        // авторизация пользователя после регистрации
        securityService.autoLogin(name, password);

        return "redirect:/customerInfo";
    }
*/

    @GetMapping(value = "/logoutSuccessful")
    public String logout(Model model, RedirectAttributes redirectAttributes) {
        MessageDto messageDto = new MessageDto("Logout Successful!", alertTextColorSuccess);
        redirectAttributes.addFlashAttribute("message", messageDto);
        return "redirect:/main";
    }
}

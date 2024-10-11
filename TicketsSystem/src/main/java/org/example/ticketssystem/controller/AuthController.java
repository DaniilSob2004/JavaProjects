package org.example.ticketssystem.controller;

import org.example.ticketssystem.model.Customer;
import org.example.ticketssystem.model.CustomerRole;
import org.example.ticketssystem.model.Role;
import org.example.ticketssystem.service.customerroleservice.CustomerRoleService;
import org.example.ticketssystem.service.customerservice.CustomerService;
import org.example.ticketssystem.service.roleservice.RoleService;
import org.example.ticketssystem.service.securityservice.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Controller
@Transactional
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRoleService customerRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping(value = {"/login"})
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping(value = "/registration")
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

    @GetMapping(value = "/logoutSuccessful")
    public String logout(Model model) {
        return "logoutSuccessful";
    }
}

package org.example.ticketssystem.controller;

import org.example.ticketssystem.model.Customer;
import org.example.ticketssystem.model.CustomerRole;
import org.example.ticketssystem.model.Role;
import org.example.ticketssystem.model.Ticket;
import org.example.ticketssystem.service.customerservice.CustomerService;
import org.example.ticketssystem.service.eventservice.EventService;
import org.example.ticketssystem.service.roleservice.RoleService;
import org.example.ticketssystem.service.ticketservice.TicketService;
import org.example.ticketssystem.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping(value = "/customerInfo")
    public String userInfo(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.pageInfoOutputMessageCreator(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "customerInfo";
    }


    @GetMapping(value = "customers/get")
    public String getCustomers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers";
    }


    @GetMapping(value = "customer/create")
    public String createCustomerPage(Model model) {
        return "createCustomer";
    }

    @PostMapping(value = "customer/create")
    public String createCustomer(@RequestParam("name") String name,
                                 @RequestParam("password") String password,
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 Model model) {
        // шифруем пароль и добавляем пользователя
        String encPassword = passwordEncoder.encode(password);
        Customer addCustomer = new Customer(0, name, email, phone, encPassword, null);
        customerService.save(addCustomer);

        // добавляем роль
        Role userRole = roleService.findRoleByName("ROLE_USER").orElse(null);
        if (userRole == null) {
            throw new RuntimeException("Role not found...");
        }

        return "redirect:/customers/get";
    }


    @GetMapping(value = "customer/getTicket")
    public String getCustomerTicketPage(Model model) {
        model.addAttribute("eventsDto", eventService.findAllDTO());
        return "getTicketShow";
    }

    @PostMapping(value = "customer/getTicket")
    public String getCustomerTicket(@RequestParam("eventId") String eventId, Model model) {
        Customer customer = customerService.getCurrentCustomer();
        if (customer == null) {
            throw new RuntimeException("Customer not found...");
        }

        int eventIdInt = Integer.parseInt(eventId);

        // получаем свободный Ticket
        Ticket ticketFree = ticketService.findFirstTicketByEventAndStatusAndCustomerNull(eventIdInt, "FREE").orElse(null);
        if (ticketFree == null) {
            return "getTicketShow";  // html нет ticket
        }

        // присваиваем и сохраняем
        ticketFree.setCustomer(customer);
        ticketService.update(ticketFree);

        return "getTicketShow";
    }
}

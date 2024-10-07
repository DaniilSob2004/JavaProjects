package org.example.ticketssystem.controller;

import org.example.ticketssystem.model.Customer;
import org.example.ticketssystem.model.Ticket;
import org.example.ticketssystem.service.customerservice.CustomerService;
import org.example.ticketssystem.service.eventservice.EventService;
import org.example.ticketssystem.service.ticketservice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;


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
                                 @RequestParam("email") String email,
                                 @RequestParam("phone") String phone,
                                 Model model) {
        Customer addCustomer = new Customer(0, name, email, phone, null);
        customerService.save(addCustomer);
        return "redirect:/customers/get";
    }


    @GetMapping(value = "customer/getTicket")
    public String getCustomerTicketPage(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("eventsDto", eventService.findAllDTO());
        return "getTicketShow";
    }

    @PostMapping(value = "customer/getTicket")
    public String getCustomerTicket(@RequestParam("customerId") String customerId,
                                    @RequestParam("eventId") String eventId,
                                    Model model) {
        int customerIdInt = Integer.parseInt(customerId);
        int eventIdInt = Integer.parseInt(eventId);

        // получаем свободный Ticket
        Ticket ticketFree = ticketService.findFirstTicketByEventAndStatusAndCustomerNull(eventIdInt, "FREE").orElse(null);
        if (ticketFree == null) {
            return "getTicketShow";  // html нет ticket
        }

        // присваиваем Ticket нашему Customer
        Customer customer = customerService.findById(customerIdInt).orElse(null);
        if (customer == null) {
            return "getTicketShow";  // html нет customer
        }

        // присваиваем и сохраняем
        ticketFree.setCustomer(customer);
        ticketService.save(ticketFree);

        return "getTicketShow";
    }
}

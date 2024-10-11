package org.example.ticketssystem.controller;

import org.example.ticketssystem.model.Ticket;
import org.example.ticketssystem.service.eventservice.EventService;
import org.example.ticketssystem.service.ticketservice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TickerController {

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;


    @GetMapping(value = "tickets/getByEvent")
    public String getTicketsByEventPage(Model model) {
        model.addAttribute("eventsDto", eventService.findAllDTO());
        return "getTicketByEvent";
    }

    @PostMapping(value = "tickets/getByEvent")
    public String getTicketsByEvent(@RequestParam("eventId") int eventId, Model model) {
        List<Ticket> tickets = ticketService.findTicketsByEventAndStatus(eventId, "FREE");
        model.addAttribute("tickets", tickets);
        return "tickets";
    }
}

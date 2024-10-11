package org.example.ticketssystem.controller;

import org.example.ticketssystem.dto.EventCreationDTO;
import org.example.ticketssystem.dto.EventDTO;
import org.example.ticketssystem.dto.PlaceDTO;
import org.example.ticketssystem.service.createeventservice.CreateEventService;
import org.example.ticketssystem.service.eventservice.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private CreateEventService createEventService;


    @GetMapping(value = "events/get")
    public String getEvents(Model model) {
        model.addAttribute("eventsDto", eventService.findAllDTO());
        return "events";
    }


    @GetMapping(value = "events/getNearest")
    public String getNearestEventsPage(Model model) {
        return "getNearestEventsPage";
    }

    @PostMapping(value = "events/getNearest")
    public String getNearestEvents(@RequestParam("startDate") String startDateString,
                                   @RequestParam("endDate") String endDateString,
                                   Model model) {
        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = LocalDate.parse(endDateString);

        List<EventDTO> eventsDto = eventService.findEventsBetweenDates(startDate, endDate);
        model.addAttribute("eventsDto", eventsDto);

        return "events";
    }

    @GetMapping(value = "event/create")
    public String createEventPage(Model model) {
        EventCreationDTO eventCreationDTO = new EventCreationDTO();
        eventCreationDTO.setPlaceDto(new PlaceDTO());
        eventCreationDTO.setTicketPacksDto(new ArrayList<>());
        model.addAttribute("eventCreationDTO", eventCreationDTO);
        return "eventCreate";
    }

    @PostMapping(value = "event/create")
    public String createEvent(@ModelAttribute EventCreationDTO eventCreationDTO, Model model) {
        if (eventCreationDTO == null) {
            return "eventCreate";
        }
        createEventService.CreateEventByDto(eventCreationDTO);
        return "redirect:/events/get";
    }
}

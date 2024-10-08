package com.example.AutoBase.controller;

import com.example.AutoBase.dto.FlightDto;
import com.example.AutoBase.dto.MessageDto;
import com.example.AutoBase.exceptions.FlightCannotBeCanceledException;
import com.example.AutoBase.exceptions.FlightIsNotFoundByException;
import com.example.AutoBase.service.PassedOneDayFlightService;
import com.example.AutoBase.service.busines.flightservice.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional
public class FlightController {

    @Value("${value.title}")
    private String pageTitle;

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassedOneDayFlightService passedOneDayFlightService;


    @GetMapping(value = "flights/get")
    public String getFlights(Model model) {
        List<FlightDto> flightsDto = flightService.findAllDto();

        model.addAttribute("title", pageTitle);
        model.addAttribute("flightsDto", flightsDto);

        return "flights";
    }

    @PostMapping(value = "flight/passed-day-way")
    public String passedDayWay(@RequestParam("flightId") int flightId, Model model, RedirectAttributes redirectAttributes) {
        System.out.println("Flight id: " + flightId);

        MessageDto messageDto = new MessageDto();
        try {
            String message = (passedOneDayFlightService.passedOneDayFlight(flightId))
                    ? "Completed flights"
                    : "Successfully passed day way";
            messageDto.setMessage(message);
            messageDto.setColor("darkgreen");
        } catch (FlightIsNotFoundByException | FlightCannotBeCanceledException | NullPointerException e) {
            messageDto.setMessage(e.getMessage());
            messageDto.setColor("darkred");
        }
        redirectAttributes.addFlashAttribute("message", messageDto);

        return "redirect:/flights/get";
    }
}

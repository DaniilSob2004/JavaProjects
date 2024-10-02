package org.example.ticketssystem.service.createeventservice;

import org.example.ticketssystem.dto.EventCreationDTO;

public interface CreateEventService {
    boolean CreateEventByDto(EventCreationDTO eventCreationDTO);
}

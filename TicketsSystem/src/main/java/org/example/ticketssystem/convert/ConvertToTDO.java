package org.example.ticketssystem.convert;

import org.example.ticketssystem.dto.EventDTO;
import org.example.ticketssystem.model.Event;
import org.springframework.stereotype.Service;

@Service
public class ConvertToTDO {
    public EventDTO convertToEventDTO(Event event) {
        return new EventDTO(
                event.getId(),
                event.getEventDate(),
                event.getName(),
                event.getPlace().getName()
        );
    }
}

package org.example.ticketssystem.service.eventservice;

import org.example.ticketssystem.dto.EventDTO;
import org.example.ticketssystem.model.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventService {
    Event save(Event event);
    int[] saveEventsList(List<Event> events);
    void update(Event event);
    void delete(Event event);
    List<Event> findAll();
    void deleteAll();

    Optional<Event> findByEventDate(LocalDate eventDate);
    Optional<Event> findById(int id);
    List<EventDTO> findAllDTO();
    List<EventDTO> findEventsBetweenDates(LocalDate startDate, LocalDate endDate);
}

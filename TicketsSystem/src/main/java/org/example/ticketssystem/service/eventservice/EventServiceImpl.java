package org.example.ticketssystem.service.eventservice;

import org.example.ticketssystem.convert.ConvertToTDO;
import org.example.ticketssystem.dao.event.EventRepository;
import org.example.ticketssystem.dto.EventDTO;
import org.example.ticketssystem.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ConvertToTDO convertToTDO;


    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public int[] saveEventsList(List<Event> events) {
        eventRepository.saveAll(events);
        return new int[0];
    }

    @Override
    public void update(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void delete(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }


    @Override
    public Optional<Event> findByEventDate(LocalDate eventDate) {
        return eventRepository.findByEventDate(eventDate);
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventRepository.findById(id);
    }

    @Transactional
    @Override
    public List<EventDTO> findAllDTO() {
        return eventRepository.findAll().stream()
                .map(convertToTDO::convertToEventDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<EventDTO> findEventsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return eventRepository.findEventsBetweenDates(startDate, endDate).stream()
                .map(convertToTDO::convertToEventDTO)
                .collect(Collectors.toList());
    }
}

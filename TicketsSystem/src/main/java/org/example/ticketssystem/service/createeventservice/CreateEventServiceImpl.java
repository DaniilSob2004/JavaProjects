package org.example.ticketssystem.service.createeventservice;

import org.example.ticketssystem.dto.EventCreationDTO;
import org.example.ticketssystem.dto.PlaceDTO;
import org.example.ticketssystem.dto.TicketPackDTO;
import org.example.ticketssystem.model.Event;
import org.example.ticketssystem.model.Place;
import org.example.ticketssystem.model.Ticket;
import org.example.ticketssystem.model.TicketStatus;
import org.example.ticketssystem.service.eventservice.EventService;
import org.example.ticketssystem.service.placeservice.PlaceService;
import org.example.ticketssystem.service.ticketservice.TicketService;
import org.example.ticketssystem.service.ticketstatusservice.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CreateEventServiceImpl implements CreateEventService {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private EventService eventService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketStatusService ticketStatusService;


    @Override
    public boolean CreateEventByDto(EventCreationDTO eventCreationDTO) {
        // если Place в бд есть, то получаем его по имени, иначе добавляем
        PlaceDTO placeDto = eventCreationDTO.getPlaceDto();
        Place place = placeService.findByName(placeDto.getName()).orElse(null);
        if (place == null) {
            Place newPlace = new Place();
            newPlace.setAddress(placeDto.getAddress());
            newPlace.setName(placeDto.getName());

            place = placeService.save(newPlace);
        }

        // получаем Event по дате, если Event есть и Place одинаковы, то false
        Event findEvent = eventService.findByEventDate(eventCreationDTO.getEventDate()).orElse(null);
        if (findEvent != null && Objects.equals(findEvent.getPlace().getId(), place.getId())) {
            return false;
        }

        // создаём Event
        Event event = new Event();
        event.setEventDate(eventCreationDTO.getEventDate());
        event.setName(eventCreationDTO.getName());
        event.setPlace(place);
        Event newEvent = eventService.save(event);

        // находим TicketStatus
        TicketStatus status = ticketStatusService.findByStatusName("FREE").orElse(null);
        if (status == null) {
            return false;
        }

        // создаём Ticket
        List<TicketPackDTO> ticketsDto = eventCreationDTO.getTicketPacksDto();
        for (TicketPackDTO ticketDto : ticketsDto) {
            float price = ticketDto.getPrice();  // цена билета
            for (int j = 1; j <= ticketDto.getQuantity(); j++) {  // кол-во билетов
                Ticket newTicket = new Ticket();
                newTicket.setCost(price);
                newTicket.setNumber(j);
                newTicket.setEvent(newEvent);
                newTicket.setStatus(status);
                ticketService.save(newTicket);
            }
        }

        return true;
    }
}

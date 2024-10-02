package org.example.ticketssystem.service.ticketstatusservice;

import org.example.ticketssystem.model.TicketStatus;
import java.util.List;
import java.util.Optional;

public interface TicketStatusService {
    void save(TicketStatus ticketStatus);
    int[] saveTicketStatusesList(List<TicketStatus> ticketStatuses);
    void update(TicketStatus ticketStatus);
    void delete(TicketStatus ticketStatus);
    List<TicketStatus> findAll();
    void deleteAll();

    Optional<TicketStatus> findByStatusName(String status);
}

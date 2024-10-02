package org.example.ticketssystem.dao.ticket;

import org.example.ticketssystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query("SELECT t FROM Ticket t WHERE t.event.id = :eventId AND t.status.id = :statusId")
    List<Ticket> findTicketsByEventAndStatus(@Param("eventId") Integer eventId, @Param("statusId") Integer statusId);

    @Query("SELECT t FROM Ticket t WHERE t.event.id = :eventId AND t.status.id = :statusId AND t.customer IS NULL")
    List<Ticket> findTicketByEventAndStatusAndCustomerNull(@Param("eventId") Integer eventId, @Param("statusId") Integer statusId);
}

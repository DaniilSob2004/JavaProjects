package org.example.ticketssystem.dao.ticketstatus;

import org.example.ticketssystem.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Integer> {
    Optional<TicketStatus> findByStatusName(String status);
}

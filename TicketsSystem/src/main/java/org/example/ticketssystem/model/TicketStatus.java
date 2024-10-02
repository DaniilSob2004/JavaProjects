package org.example.ticketssystem.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "ticket_status")
public class TicketStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status_name", nullable = false)
    private String statusName;
}

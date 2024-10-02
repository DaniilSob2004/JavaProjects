package org.example.ticketssystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketPackDTO {
    private float price;
    private int quantity;
}

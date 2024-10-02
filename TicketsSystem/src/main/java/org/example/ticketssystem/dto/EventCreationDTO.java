package org.example.ticketssystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class EventCreationDTO {
    private LocalDate eventDate;
    private String name;
    private List<TicketPackDTO> ticketPacksDto;
    private PlaceDTO placeDto;
}

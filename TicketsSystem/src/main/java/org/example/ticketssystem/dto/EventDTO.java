package org.example.ticketssystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EventDTO {
    private Integer id;
    private LocalDate eventDate;
    private String name;
    private String placeName;
}

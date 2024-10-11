package org.example.ticketssystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCreationDTO {
    // сообщает Spring, что дата должна быть преобразована из строки в формат yyyy-MM-dd, стандартным ISO форматом
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  // указываем формат даты
    private LocalDate eventDate;
    private String name;
    private List<TicketPackDTO> ticketPacksDto;
    private PlaceDTO placeDto;
}

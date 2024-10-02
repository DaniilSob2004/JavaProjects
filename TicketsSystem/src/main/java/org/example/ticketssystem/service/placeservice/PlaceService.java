package org.example.ticketssystem.service.placeservice;

import org.example.ticketssystem.model.Place;
import java.util.List;
import java.util.Optional;

public interface PlaceService {
    Place save(Place place);
    int[] savePlacesList(List<Place> places);
    void update(Place place);
    void delete(Place place);
    List<Place> findAll();
    void deleteAll();

    Optional<Place> findByName(String name);
}

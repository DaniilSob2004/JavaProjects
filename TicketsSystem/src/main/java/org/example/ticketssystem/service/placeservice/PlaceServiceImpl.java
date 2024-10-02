package org.example.ticketssystem.service.placeservice;

import org.example.ticketssystem.dao.place.PlaceRepository;
import org.example.ticketssystem.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    @Override
    public Place save(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public int[] savePlacesList(List<Place> places) {
        placeRepository.saveAll(places);
        return new int[0];
    }

    @Override
    public void update(Place place) {
        placeRepository.save(place);
    }

    @Override
    public void delete(Place place) {
        placeRepository.delete(place);
    }

    @Override
    public List<Place> findAll() {
        return placeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        placeRepository.deleteAll();
    }


    @Override
    public Optional<Place> findByName(String name) {
        return placeRepository.findByName(name);
    }
}

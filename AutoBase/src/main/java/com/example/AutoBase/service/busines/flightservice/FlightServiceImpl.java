package com.example.AutoBase.service.busines.flightservice;

import com.example.AutoBase.dao.flight.FlightRepository;
import com.example.AutoBase.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;


    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public int[] saveFlightsList(List<Flight> flights) {
        flightRepository.saveAll(flights);
        return new int[0];
    }

    @Override
    public void update(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteAll() {
        flightRepository.deleteAll();
    }


    @Override
    public void passedOneDayWay(Flight flight) {
        int curDay = flight.getCountDayWay();
        if (curDay > 0) {
            flight.setCountDayWay(curDay - 1);
            flightRepository.save(flight);
        }
    }

    @Override
    public boolean flightBeenCompletedNow(Flight flight) {
        return flight.getCountDayWay() <= 0;
    }
}

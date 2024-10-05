package com.example.AutoBase.service.busines.flightservice;

import com.example.AutoBase.model.Flight;
import java.util.List;

public interface FlightService {
    void save(Flight flight);
    int[] saveFlightsList(List<Flight> flights);
    void update(Flight flight);
    void delete(Flight flight);
    List<Flight> findAll();
    void deleteAll();

    void passedOneDayWay(Flight flight);
    boolean flightBeenCompletedNow(Flight flight);
}

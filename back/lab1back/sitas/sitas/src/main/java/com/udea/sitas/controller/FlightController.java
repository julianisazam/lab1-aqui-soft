package com.udea.sitas.controller;

import com.udea.sitas.model.Flight;
import com.udea.sitas.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam(value = "startDate") String startDate,
                                      @RequestParam(value = "endDate") String endDate,
                                      @RequestParam(value= "origin") String origin,
                                      @RequestParam(value= "destination") String destination,
                                      @RequestParam(value= "maxPrice", required = false) Double maxPrice,
                                      @RequestParam(value= "category", required = false) String category,
                                      @RequestParam(value = "baggage", required = false) String baggage) {
        return flightService.findFlights(LocalDate.parse(startDate), LocalDate.parse(endDate), origin, destination, maxPrice, category, baggage);

    }
}
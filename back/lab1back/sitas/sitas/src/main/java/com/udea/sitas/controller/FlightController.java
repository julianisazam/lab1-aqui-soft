package com.udea.sitas.controller;

import com.udea.sitas.model.Flight;
import com.udea.sitas.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "http://localhost:3000")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam(value = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "timePeriod", required = false) String timePeriod,
            @RequestParam(value = "hour", required = false) Integer hour,
            @RequestParam(value = "baggageType", required = false) String baggageType,
            @RequestParam(value = "travelClass", required = false) String travelClass
    ) {

        LocalTime time = null;
        if (timePeriod != null && hour != null) {
            int adjustedHour = (timePeriod.equalsIgnoreCase("PM") && hour != 12) ? hour + 12 : hour;
            time = LocalTime.of(adjustedHour, 0);
        }

        return flightService.findFlights(startDate, endDate, origin, destination, maxPrice, time, baggageType, travelClass);
    }
}
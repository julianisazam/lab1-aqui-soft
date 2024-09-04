package com.udea.sitas.service;

import com.udea.sitas.model.Flight;
import com.udea.sitas.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static com.udea.sitas.util.StringUtil.formatStrings;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination,
                                    Double maxPrice, LocalTime time, String baggageType, String travelClass) {

        // Construir la clave de combinación de parámetros, asumiendo que origin y destination siempre están presentes
        String key = "11" + // Origen y destino siempre presentes
                (maxPrice != null ? "1" : "0") +
                (time != null ? "1" : "0") +
                (baggageType != null ? "1" : "0") +
                (travelClass != null ? "1" : "0");


        origin = formatStrings(origin);
        destination = formatStrings(destination);

        System.out.println(key);
        switch (key) {
            case "11111": // Todos los filtros excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageTypeAndTravelClass(
                        origin, destination, maxPrice, time, baggageType, travelClass);
            case "11110": // Sin filtro de clase, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageType(
                        origin, destination, maxPrice, time, baggageType);
            case "11101": // Sin filtro de equipaje, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndTravelClass(
                        origin, destination, maxPrice, time, travelClass);
            case "11011": // Sin filtro de hora, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndBaggageTypeAndTravelClass(
                        origin, destination, maxPrice, baggageType, travelClass);
            case "11001": // Sin filtro de hora ni equipaje, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndTravelClass(
                        origin, destination, maxPrice, travelClass);
            case "11010": // Sin filtro de hora ni clase, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndBaggageType(
                        origin, destination, maxPrice, baggageType);
            case "11100": // Sin filtro de equipaje ni clase, excepto fechas
                return flightRepository.findByOriginAndDestinationAndPriceLessThanEqualAndTime(
                        origin, destination, maxPrice, time);
            case "11000": // Solo origen y destino (sin fechas)
            default:
                return flightRepository.findByOriginAndDestination(origin, destination);

        }

    }
}
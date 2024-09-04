package com.udea.sitas.service;

import com.udea.sitas.model.Flight;
import com.udea.sitas.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findFlights(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String category, String baggage) {
        // Generar una clave de combinación de parámetros para usar en el switch
        String key = (category != null ? "1" : "0") +
                (baggage != null ? "1" : "0") +
                (maxPrice != null ? "1" : "0");

        switch (key) {
            case "111": // category, baggage, maxPrice no son nulos
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndBaggageContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, baggage, category, maxPrice);

            case "110": // category, baggage no son nulos, maxPrice es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndBaggageContainingIgnoreCase(
                        startDate, endDate, origin, destination, category,baggage);

            case "101": // category y maxPrice no son nulos, baggage es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, category, maxPrice);

            case "011": // baggageType y maxPrice no son nulos, category es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndBaggageContainingIgnoreCaseAndPriceLessThanEqual(
                        startDate, endDate, origin, destination, baggage, maxPrice);

            case "100": // solo category no es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCase(startDate, endDate,origin, destination,category);

            case "010": // solo baggageType no es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndBaggageContainingIgnoreCase(startDate, endDate,origin, destination,baggage);

            case "001": // solo maxPrice no es nulo
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(startDate, endDate,origin, destination, maxPrice);

            case "000": // todos son nulos
            default:
                return flightRepository.findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(startDate, endDate, origin, destination);
        }
    }

}
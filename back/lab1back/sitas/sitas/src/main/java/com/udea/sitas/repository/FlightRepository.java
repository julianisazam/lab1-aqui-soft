package com.udea.sitas.repository;

import com.udea.sitas.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndBaggageContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, String destination, String baggage, String category, Double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndBaggageContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination, String category, String baggage);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, String destination, String category, Double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndCategoryContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination, String category);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndBaggageContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination, String baggage);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCase(LocalDate startDate, LocalDate endDate, String origin, String destination);

    List<Flight> findByDateBetweenAndOriginContainingIgnoreCaseAndDestinationContainingIgnoreCaseAndBaggageContainingIgnoreCaseAndPriceLessThanEqual(LocalDate startDate, LocalDate endDate, String origin, String destination, String baggage, Double maxPrice);

}
package com.udea.sitas.repository;

import com.udea.sitas.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageTypeAndTravelClass(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, LocalTime time, String baggageType, String travelClass);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndBaggageTypeAndTravelClass(String origin, String destination, Double maxPrice, String baggageType, String travelClass);

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndBaggageType(String origin, String destination, Double maxPrice, String baggageType);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndTravelClass(String origin, String destination, Double maxPrice, String travelClass);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndBaggageTypeAndTravelClass(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String baggageType, String travelClass);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndTimeAndTravelClass(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, LocalTime time, String travelClass);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageType(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, LocalTime time, String baggageType);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndTravelClass(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String travelClass);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndBaggageType(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, String baggageType);

    List<Flight> findByDateBetweenAndOriginAndDestinationAndPriceLessThanEqualAndTime(LocalDate startDate, LocalDate endDate, String origin, String destination, Double maxPrice, LocalTime time);

    List<Flight> findByDateBetweenAndOriginAndDestination(LocalDate startDate, LocalDate endDate, String origin, String destination);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageTypeAndTravelClass(String origin, String destination, Double maxPrice, LocalTime time, String baggageType, String travelClass);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndTravelClass(String origin, String destination, Double maxPrice, LocalTime time, String travelClass);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndTimeAndBaggageType(String origin, String destination, Double maxPrice, LocalTime time, String baggageType);

    List<Flight> findByOriginAndDestinationAndPriceLessThanEqualAndTime(String origin, String destination, Double maxPrice, LocalTime time);
}
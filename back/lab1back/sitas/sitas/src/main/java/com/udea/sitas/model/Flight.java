package com.udea.sitas.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

//Plan Old Java Object -- POJO
@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;
    private LocalDate date;
    private double price;
    private String category;
    private String baggage;

    public Flight() {
    }

    public Flight(Long id, String origin, String destination, LocalDate date, double price, String category, String baggageType) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.price = price;
        this.category = category;
        this.baggage = baggageType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBaggageType() {
        return baggage;
    }

    public void setBaggageType(String baggageType) {
        this.baggage = baggageType;
    }

    //IDIOMS

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(getId(), flight.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

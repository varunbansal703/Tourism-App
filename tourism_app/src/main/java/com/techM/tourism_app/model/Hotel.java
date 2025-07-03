package com.techM.tourism_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private double pricePerNight;
    private int availableRooms;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public Hotel() {}

    public Hotel(String name, String location, double pricePerNight, int availableRooms, Destination destination) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
        this.destination = destination;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double pricePerNight) { this.pricePerNight = pricePerNight; }

    public int getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(int availableRooms) { this.availableRooms = availableRooms; }

    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
}

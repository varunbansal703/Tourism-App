package com.techM.tourism_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "travel_options")
public class TravelOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mode;
    private String provider;
    private String departureCity;
    private String arrivalCity;
    private double price;
    private String departureTime;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Destination destination;

    public TravelOption() {}

    // ✅ Add full-args constructor if needed
    public TravelOption(String mode, String provider, String departureCity, String arrivalCity,
                        double price, String departureTime, Destination destination) {
        this.mode = mode;
        this.provider = provider;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.price = price;
        this.departureTime = departureTime;
        this.destination = destination;
    }

    // ✅ IMPORTANT: Add getters and setters for ALL fields

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getDepartureCity() { return departureCity; }
    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }

    public String getArrivalCity() { return arrivalCity; }
    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }

    public Destination getDestination() { return destination; }
    public void setDestination(Destination destination) { this.destination = destination; }
}

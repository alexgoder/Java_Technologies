package com.example.demo;

import org.springframework.stereotype.Component;

// Base Class
@Component
public class Vehicle {

    private double price;
    private int maximumSpeed;

    public Vehicle() {
    }

    public Vehicle(double price, int maximumSpeed) {
        this.price = price;
        this.maximumSpeed = maximumSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle [Price=" + price + ", Maximum Speed=" + maximumSpeed + " km/h]";
    }
}

// Derived Class: Autovehicle
// Derived Class: Motorcycle
// Derived Class: Truck
// Main Application Class


package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Autovehicle extends Vehicle {

    private String brand;
    private int yearOfFabrication;

    public Autovehicle() {
    }

    @Autowired
    public Autovehicle(@Value("25000") double price, @Value("180") int maximumSpeed, @Value("Ford") String brand, @Value("2021") int yearOfFabrication) {
        super(price, maximumSpeed);
        this.brand = brand;
        this.yearOfFabrication = yearOfFabrication;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autovehicle [Brand=" + brand + ", Year of Fabrication=" + yearOfFabrication + "]";
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Motorcycle extends Vehicle {

    private String type;

    public Motorcycle() {
    }

    @Autowired
    public Motorcycle(@Value("12000") double price, @Value("150") int maximumSpeed, @Value("Sport") String type) {
        super(price, maximumSpeed);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Motorcycle [Type=" + type + "]";
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Truck extends Vehicle {

    private double maximumLoad;

    public Truck() {
    }

    @Autowired
    public Truck(@Value("45000") double price, @Value("120") int maximumSpeed, @Value("15") double maximumLoad) {
        super(price, maximumSpeed);
        this.maximumLoad = maximumLoad;
    }

    public double getMaximumLoad() {
        return maximumLoad;
    }

    public void setMaximumLoad(double maximumLoad) {
        this.maximumLoad = maximumLoad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Truck [Maximum Load=" + maximumLoad + " tons]";
    }
}

@Configuration
@ComponentScan(basePackages = "com.example.demo")
class AppConfig {
}

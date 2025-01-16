package com.example;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/Users/alexa/Desktop/JAVA/jt_proj2/prob3/pb3/src/main/resources/applicationContext.xml");
        CarDAO carDAO = context.getBean(CarDAO.class);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a car");
            System.out.println("2. Delete a car");
            System.out.println("3. Search for a car");
            System.out.println("4. Display all cars");
            System.out.println("5. Display number of cars by brand");
            System.out.println("6. Display number of cars under 100000 km");
            System.out.println("7. Display cars newer than 5 years");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter car registration number:");
                    String regNum = scanner.nextLine();
                    System.out.println("Enter car brand:");
                    String brand = scanner.nextLine();
                    System.out.println("Enter car year of fabrication:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter car color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter car kilometers:");
                    int km = scanner.nextInt();

                    Car car = new Car();
                    car.setRegistrationNumber(regNum);
                    car.setBrand(brand);
                    car.setYearOfFabrication(year);
                    car.setColor(color);
                    car.setKm(km);
                    carDAO.addCar(car);
                    System.out.println("Car added successfully!");
                    break;

                case 2:
                    System.out.println("Enter car registration number to delete:");
                    regNum = scanner.nextLine();
                    carDAO.deleteCar(regNum);
                    System.out.println("Car deleted successfully!");
                    break;

                case 3:
                    System.out.println("Enter car registration number to search:");
                    regNum = scanner.nextLine();
                    Car foundCar = carDAO.searchCar(regNum);
                    System.out.println("Car found: " + foundCar);
                    break;

                case 4:
                    List<Car> allCars = carDAO.getAllCars();
                    allCars.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Enter brand to search:");
                    brand = scanner.nextLine();
                    int countByBrand = carDAO.countCarsByBrand(brand);
                    System.out.println("Number of cars with brand " + brand + ": " + countByBrand);
                    break;

                case 6:
                    int countUnder100k = carDAO.countCarsUnder100kKm();
                    System.out.println("Number of cars with less than 100,000 km: " + countUnder100k);
                    break;

                case 7:
                    List<Car> newCars = carDAO.getCarsNewerThan5Years();
                    newCars.forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}

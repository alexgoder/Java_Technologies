package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");

        // Retrieve beans defined in Beans.xml
        Vehicle autovehicle1 = (Vehicle) context1.getBean("autoVehicle1");
        Vehicle motorcycle1 = (Vehicle) context1.getBean("motorcycle1");
        Vehicle truck1 = (Vehicle) context1.getBean("truck1");

        // Display the objects
        System.out.println(autovehicle1);
        System.out.println(motorcycle1);
        System.out.println(truck1);

        // Close the context
        ((ClassPathXmlApplicationContext) context1).close();

        Vehicle autovehicle = context.getBean(Autovehicle.class);
        Vehicle motorcycle = context.getBean(Motorcycle.class);
        Vehicle truck = context.getBean(Truck.class);

        System.out.println(autovehicle);
        System.out.println(motorcycle);
        System.out.println(truck);

        context.close();
    }
}

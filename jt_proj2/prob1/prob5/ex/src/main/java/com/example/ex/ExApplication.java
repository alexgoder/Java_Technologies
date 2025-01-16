package com.example.ex;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class ExApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ExApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("/Users/alexa/Desktop/JAVA/jt_proj2/prob1/prob5/ex/src/main/resources/ex5.xml");
        Rectangle r = (Rectangle) context.getBean("rectangle");
        r.area();
	}

}

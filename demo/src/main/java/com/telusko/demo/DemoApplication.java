package com.telusko.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


//		Created Obj. manually
//		Alien obj = new Alien();
//		obj.code();


		Alien obj = context.getBean(Alien.class);
		obj.code();

	}

}

package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("--- starting context ---");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("--- context ready; desktop not created yet ---");

        Alien obj1 = (Alien) context.getBean("alien");
        System.out.println("Alien age: " + obj1.getAge());

        System.out.println("--- requesting desktop bean ---");
        Computer desktop = (Computer) context.getBean("desktop");
        desktop.compile();

    }
}

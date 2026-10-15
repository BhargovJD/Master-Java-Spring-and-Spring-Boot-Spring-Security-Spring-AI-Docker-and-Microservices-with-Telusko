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

//        Obj. created in this line
        ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");

//      System.out.println( "Hello World!" );
//        Alien obj = new Alien();
//        obj.code();

        Alien obj1 = (Alien) context.getBean("alien");
        System.out.println(obj1.getAge());

    }
}

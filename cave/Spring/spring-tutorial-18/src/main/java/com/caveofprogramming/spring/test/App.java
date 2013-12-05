package com.caveofprogramming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Jungle jungle = (Jungle) context.getBean("jungle");
        System.out.println(jungle);
        ((ClassPathXmlApplicationContext) context).close();
    }

}

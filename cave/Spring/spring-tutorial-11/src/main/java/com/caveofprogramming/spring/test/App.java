package com.caveofprogramming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Person person1 = (Person) context.getBean("person");//Default singleton
        person1.setTaxId(666);
        Person person2 = (Person) context.getBean("person");//Default singleton

        System.out.println(person2);

        ((ClassPathXmlApplicationContext) context).close();
    }
}

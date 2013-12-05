package com.caveofprogramming.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        FruitBasket basket = (FruitBasket) context.getBean("basket");//Default singleton
        System.out.println(basket);
        ((ClassPathXmlApplicationContext) context).close();
    }
}

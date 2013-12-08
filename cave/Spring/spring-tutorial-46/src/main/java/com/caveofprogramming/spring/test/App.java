package com.caveofprogramming.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");

        OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

        try {
            Offer offer1 = new Offer("Dave", "dave@nowhere.com", "Coding Java");
            Offer offer2 = new Offer("Karen", "karen@nowhere.com", "software testing");
            if (offersDao.create(offer1)) {
                System.out.println("Created offer object 1.");
            }
            if (offersDao.create(offer2)) {
                System.out.println("Created offer object 2.");
            }
            List<Offer> offers = offersDao.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }

        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Unable to connect to database.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((ClassPathXmlApplicationContext) context).close();
    }

}

package com.caveofprogramming.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

        try {
            List<Offer> offers = offersDao.getOffers();

            for (Offer offer : offers) {
                System.out.println(offer);
            }

            Offer offer = offersDao.getOffer(2);

            System.out.println("Should be Mike: " + offer);
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println("Unable to connect to database.");
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        ((ClassPathXmlApplicationContext) context).close();
    }

}

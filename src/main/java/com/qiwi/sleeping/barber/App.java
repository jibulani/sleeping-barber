package com.qiwi.sleeping.barber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etrofimov on 04.09.17.
 */
public class App {

    static Barber barber;

    public static void main(String[] args) {
        barber = new Barber();
        BarberShop barberShop = new BarberShop();
        barber.start();
        List<Customer> customers = CustomerListGenerator.generateCustomerList(barber, barberShop);
        customers.forEach(Thread::start);
    }
}

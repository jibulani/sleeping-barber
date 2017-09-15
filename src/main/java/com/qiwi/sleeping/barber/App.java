package com.qiwi.sleeping.barber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by etrofimov on 04.09.17.
 */
public class App {

    public static void main(String[] args) {
        BarberShop barberShop = new BarberShop();
        Barber barber = new Barber(barberShop);
        barber.start();
        CustomerListGenerator customerListGenerator = new CustomerListGenerator(barber, barberShop);
        customerListGenerator.start();
    }
}

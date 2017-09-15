package com.qiwi.sleeping.barber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by etrofimov on 06.09.17.
 */
public class CustomerListGenerator extends Thread {

    Barber barber;
    BarberShop barberShop;
    int counter = 0;

    CustomerListGenerator(Barber barber, BarberShop barberShop) {
        this.barber = barber;
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while (counter < 20) {
            Random random = new Random();
            List<Customer> customers = new ArrayList<>();
            for (int i = 0; i < random.nextInt(1000); i++) {
                customers.add(new Customer(barberShop));
            }
            customers.forEach(Thread::start);
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

}

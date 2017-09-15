package com.qiwi.sleeping.barber;

import java.util.ArrayList;

/**
 * Created by etrofimov on 06.09.17.
 */
public class BarberShop {

    ArrayList<Customer> currCustomers;

    public synchronized void addCustomer(Customer customer) {
        if (currCustomers == null) {
            currCustomers = new ArrayList<>();
        }
        if (currCustomers.size() > 10) {
            System.out.println("Barbershop is full, customer go out");
        } else {
            currCustomers.add(customer);
            System.out.println("New customer added in barbershop");
            notify();
        }
    }

    public synchronized void shave() {
        if (currCustomers == null) {
            currCustomers = new ArrayList<>();
        }
        while (currCustomers.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currCustomers.remove(currCustomers.size() - 1);
        System.out.println("Barber shaved customer");
    }
}

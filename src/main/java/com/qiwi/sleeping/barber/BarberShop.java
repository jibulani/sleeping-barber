package com.qiwi.sleeping.barber;

import java.util.ArrayList;
import java.util.Random;

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
            System.out.println("Barbershop is full, customer go out, customer #:" + customer.name);
        } else {
            currCustomers.add(customer);
            System.out.println("New customer added in barbershop, customer #:" + customer.name);
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
        Random random = new Random();
        System.out.println("Barber start");
        try {
            Thread.sleep(random.nextInt(10) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = currCustomers.remove(currCustomers.size() - 1);
        System.out.println("Barber shaved customer with #:" + customer.name);

    }
}

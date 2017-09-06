package com.qiwi.sleeping.barber;

import java.util.ArrayList;

/**
 * Created by etrofimov on 06.09.17.
 */
public class BarberShop {

    ArrayList<Customer> currCustomers;

    public void addCustomer(Customer customer) {
        if (currCustomers == null) {
            currCustomers = new ArrayList<>();
        }
        currCustomers.add(customer);
    }
}

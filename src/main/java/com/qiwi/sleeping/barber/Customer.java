package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Customer extends Thread {

    static int counter = 0;
    int name;
    private BarberShop barberShop;

    public Customer(BarberShop barberShop) {
        this.barberShop = barberShop;
        name = counter;
        counter++;
    }

    @Override
    public void run() {
        barberShop.addCustomer(this);
    }
}

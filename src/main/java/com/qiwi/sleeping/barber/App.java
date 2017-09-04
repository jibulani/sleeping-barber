package com.qiwi.sleeping.barber;

import java.util.ArrayList;

/**
 * Created by etrofimov on 04.09.17.
 */
public class App {

    static Barber barber;

    public static void main(String[] args) {
        barber = new Barber();
        Customer customer = new Customer(barber);
        barber.start();
        ArrayList<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            customers.add(new Customer(barber));
        }
        customers.forEach(Thread::start);
        customer.start();
        customer.interrupt();
        customers.forEach(Thread::interrupt);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread: Barber isSleeping = " + barber.getIsSleeping());
        ArrayList<Customer> customers2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customers2.add(new Customer(barber));
        }
        customers2.forEach(Thread::start);
        customers2.forEach(Thread::interrupt);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread: Barber isSleeping = " + barber.getIsSleeping());
        barber.interrupt();
    }
}

package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Customer extends Thread {

    private static volatile int freeChairs;
    private static volatile Barber barber;

    public Customer(Barber barber) {
        super();
        Customer.barber = barber;
    }

    @Override
    public void run() {
        freeChairs = barber.customerChairs > 0 ? barber.customerChairs-- : 0;
        System.out.println("New customer run");
        System.out.println("Barber isSleeping = " + barber.getIsSleeping());
        System.out.println("Free chairs = " + barber.customerChairs);
        if (freeChairs > 0) {
            do {
                if (!Thread.interrupted()) {
                    if (barber.getIsSleeping()) {
                        System.out.println("Customer wake up barber");
                        barber.setSleeping(false);
                        System.out.println("Barber isSleeping = " + barber.getIsSleeping());
                    }
                } else {
                    System.out.println("Customer go out");
                    barber.customerChairs++;
                    System.out.println("Barber isSleeping = " + barber.getIsSleeping());
                    System.out.println("Free chairs = " + barber.customerChairs);
                    return;
                }
            } while (true);
        } else {
            System.out.println("No chairs are available");
        }
    }
}

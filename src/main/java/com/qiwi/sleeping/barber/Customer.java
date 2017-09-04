package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Customer extends Thread {

    private int freeChairs;
    private Barber barber;

    public Customer(Barber barber) {
        super();
        this.barber = barber;
    }

    @Override
    public void run() {
        if (barber.getCustomerChairs() > 0) {
            freeChairs = barber.getCustomerChairs();
            barber.decreaseCustomerChairs();
        } else {
            freeChairs = 0;
        }
        System.out.println("New customer run");
        System.out.println("Barber isSleeping = " + barber.getIsSleeping());
        System.out.println("Free chairs = " + barber.getCustomerChairs());
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
                    barber.increaseCustomerChairs();
//                    System.out.println("Free chairs = " + barber.getCustomerChairs());
//                    System.out.println("Barber isSleeping = " + barber.getIsSleeping());
                    return;
                }
            } while (true);
        } else {
            System.out.println("No chairs are available");
        }
    }
}

package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Customer extends Thread {

    private int freeChairs;
    private Barber barber;
    private BarberShop barberShop;

    public Customer(Barber barber, BarberShop barberShop) {
        super();
        this.barber = barber;
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        System.out.println("New customer run");
        if (barber.getCustomerChairs() > 0) {
            freeChairs = barber.getCustomerChairs();
            barber.decreaseCustomerChairs();
        } else {
            freeChairs = 0;
        }
        System.out.println("Barber isSleeping = " + barber.getIsSleeping());
        System.out.println("Free chairs = " + barber.getCustomerChairs());
        if (freeChairs > 0) {
            barberShop.addCustomer(this);
            if (barber.getIsSleeping()) {
                System.out.println("Customer wake up barber");
                barber.setSleeping(false);
            }
            System.out.println("Customer wait");
            System.out.println("Customer go out");
            barber.increaseCustomerChairs();
            barberShop.currCustomers.remove(this);
        } else {
            System.out.println("No chairs are available");
        }
    }
}

package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Barber extends Thread {

    private volatile boolean isSleeping = true;
    private int customerChairs = 10;

    public synchronized void setSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public synchronized boolean getIsSleeping() {
        return isSleeping;
    }

    public synchronized void increaseCustomerChairs() {
        customerChairs++;
    }

    public synchronized void decreaseCustomerChairs() {
        customerChairs--;
    }

    public synchronized int getCustomerChairs() {
        return customerChairs;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                if (customerChairs == 10) {
                    setSleeping(true);
                }
            } else  {
                return;
            }
        } while (true);
    }
}

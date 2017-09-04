package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Barber extends Thread {

    private volatile boolean isSleeping = true;
    public int customerChairs = 10;

    public void setSleeping(boolean isSleeping) {
        this.isSleeping = isSleeping;
    }

    public boolean getIsSleeping() {
        return isSleeping;
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

package com.qiwi.sleeping.barber;

/**
 * Created by etrofimov on 04.09.17.
 */
public class Barber extends Thread {

    BarberShop barberShop;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }


    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                barberShop.shave();
            } else  {
                return;
            }
        } while (true);
    }
}

package oppg3Alternativ;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Servitor extends Thread{

    // Klassevariabler
    private static final long WAIT_TIME_MIN = 2000;
    private static final long WAIT_TIME_MAX = 6000;
    private static List<Servitor> servitorer = new ArrayList<>();;

    // Objektvariabler
    private String navn;
    private HamburgerBrett brett;
    private AtomicBoolean running = new AtomicBoolean(false);

    // Konstruktør
    public Servitor(String navn, HamburgerBrett brett) {
        this.navn = navn;
        this.brett = brett;
        servitorer.add(this);
        this.start();
    }

    // Strengrepresentasjon av objektet
    @Override
    public String toString() {
        return navn + " (servitør)";
    }

    // Hovedloop for tråden
    @Override
    public synchronized void run() {
        Thread.currentThread().setName(this.toString());
        running.set(true);
        while (running.get()) {
            try {
                // Bruk tid på å servere hamburger
                sleep(ThreadLocalRandom.current().nextLong(WAIT_TIME_MIN, WAIT_TIME_MAX));
                // Prøv å ta en hamburger fra brettet, vent på hamburger hvis brettet er tomt
                Hamburger burger = brett.burgere.take();
                // Etter at hamburger er tatt så fortsetter programmet
                System.out.println(this + " tar av hamburger " + burger + ". " + brett);
            } catch (InterruptedException e) {}

        }
    }

}

package oppg3Alternativ;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class Kokk extends Thread{

    // Klassevariabler
    private static final long WAIT_TIME_MIN = 2000;
    private static final long WAIT_TIME_MAX = 6000;
    private static List<Kokk> kokker = new ArrayList<>();

    // Objektvariabler
    private String navn;
    private HamburgerBrett brett;
    private AtomicBoolean running = new AtomicBoolean(false);

    // Konstruktør
    public Kokk(String navn, HamburgerBrett brett) {
        this.navn = navn;
        this.brett = brett;
        kokker.add(this);
        this.start();
    }

    // Strengrepresentasjon av objektet
    @Override
    public String toString() {
        return navn + " (kokk)";
    }

    // Hovedloop for tråden
    @Override
    public synchronized void run() {
        Thread.currentThread().setName(this.toString());
        running.set(true);
        while (running.get()) {
            try {
                // Bruk tid på å lage ny hamburger
                sleep(ThreadLocalRandom.current().nextLong(WAIT_TIME_MIN, WAIT_TIME_MAX));
                // Opprett nytt hamburger-objekt
                Hamburger burger = new Hamburger();
                // Prøv å legge den nye hamburgeren på brettet, vent på ledig plass hvis brettet er fullt
                brett.burgere.put(burger);
                // Etter at hamburgeren er plassert på brettet så fortsetter programmet
                System.out.println(this + " legger på hamburger " + burger + ". " + brett);
            } catch (InterruptedException e) {}

        }
    }

}

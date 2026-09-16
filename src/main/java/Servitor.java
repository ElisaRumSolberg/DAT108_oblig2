import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread{

    // Klassevariabler
    private static final long WAIT_TIME_MIN = 2000;
    private static final long WAIT_TIME_MAX = 6000;
    public static List<Servitor> servitorer = new ArrayList<>();;

    // Objektvariabler
    private String navn;
    private HamburgerBrett brett;
    private boolean running;

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

    // Tråd loop
    @Override
    public synchronized void run() {
        Thread.currentThread().setName(this.toString());
        running = true;
        while (running) {
            if (!brett.pop(this)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            try {
                sleep(ThreadLocalRandom.current().nextLong(WAIT_TIME_MIN, WAIT_TIME_MAX));
            } catch (InterruptedException e) {
            }
        }
    }

    // Våkne en tråd som venter
    public synchronized void wake() {
        this.notify();
    }
}

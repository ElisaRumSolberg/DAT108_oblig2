package oppg3Alternativ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// Alternativ løsning til Oppgave 3 (begge løsningene er egentlig veldig like)
public class Oppg3 {

    // Klassevariabler
    private static final int CAP = 4;

    // Entry-point for programmet
    public static void main(String[] args) {
        BlockingQueue<Hamburger> brett = new LinkedBlockingQueue<>(CAP);
        System.out.printf("Starter hamburger simulering med brett som har kapasitet til %d burgere.%n", CAP);
        new Kokk("Anne", brett);
        new Kokk("Erik", brett);
        new Kokk("Knut", brett);
        new Servitor("Mia", brett);
        new Servitor("Per", brett);
    }
}

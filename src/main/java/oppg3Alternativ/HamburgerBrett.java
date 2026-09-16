package oppg3Alternativ;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class HamburgerBrett {

    // Objektvariabler
    public BlockingQueue<Hamburger> burgere;

    // Konstruktør
    public HamburgerBrett(int cap) {
        burgere = new LinkedBlockingQueue<>(cap);
    }

    // Strengrepresentasjon av objektet
    @Override
    public String toString() {
        return "Brett: " + burgere;
    }

}

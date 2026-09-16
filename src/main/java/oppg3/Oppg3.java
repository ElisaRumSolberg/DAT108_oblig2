package oppg3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Oppg3 {

    public static void main(String[] args) {

        final int KAPASITET = 4;

        BlockingQueue<HamburgerBQ> brett =
                new ArrayBlockingQueue<>(KAPASITET);

        KokkBQ k1 = new KokkBQ(brett, "Anne");
        KokkBQ k2 = new KokkBQ(brett, "Erik");
        KokkBQ k3 = new KokkBQ(brett, "Knut");

        ServitorBQ s1 = new ServitorBQ(brett, "Mia");
        ServitorBQ s2 = new ServitorBQ(brett, "Per");

        System.out.println("I denne simuleringen har vi");
        System.out.println("3 kokker [Anne, Erik, Knut]");
        System.out.println("2 servitører [Mia, Per]");
        System.out.println("Kapasiteten til brettet er 4 hamburgere.");
        System.out.println("Vi starter ...");

        k1.start();
        k2.start();
        k3.start();

        s1.start();
        s2.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        k1.interrupt();
        k2.interrupt();
        k3.interrupt();

        s1.interrupt();
        s2.interrupt();

        System.out.println("\nSimuleringen er avsluttet.");
    }
}
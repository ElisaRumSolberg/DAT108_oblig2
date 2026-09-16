import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

    private Queue<Hamburger> brett;
    private int kapasitet;
    private int nesteNummer = 1;

    public HamburgerBrett(int kapasitet) {
        this.kapasitet = kapasitet;
        this.brett = new LinkedList<>();
    }


    public synchronized void leggPa(String kokkNavn) {

        while (brett.size() >= kapasitet) {

            System.out.println(
                    kokkNavn
                            + " (kokk) klar med hamburger, men brett fullt. Venter!"
            );

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        Hamburger hamburger = new Hamburger(nesteNummer);
        nesteNummer++;

        brett.add(hamburger);

        System.out.println(
                kokkNavn
                        + " (kokk) legger på hamburger "
                        + hamburger
                        + ". Brett: "
                        + brett
        );

        notifyAll();
    }


    public synchronized Hamburger taAv(String servitorNavn) {

        while (brett.isEmpty()) {

            System.out.println(
                    servitorNavn
                            + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!"
            );

            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }

        Hamburger hamburger = brett.poll();

        System.out.println(
                servitorNavn
                        + " (servitør) tar av hamburger "
                        + hamburger
                        + ". Brett: "
                        + brett
        );

        notifyAll();

        return hamburger;
    }
}
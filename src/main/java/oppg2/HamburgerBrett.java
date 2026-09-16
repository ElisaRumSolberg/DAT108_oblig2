package oppg2;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

    // Objektvariabler
    private Queue<Kokk> kokkVenter = new LinkedList<>();
    private Queue<Servitor> servitorVenter = new LinkedList<>();
    private Queue<Hamburger> burgere = new LinkedList<>();
    private final int cap;

    // Konstruktør
    public HamburgerBrett(int cap) {
        this.cap = cap;
    }

    // Strengrepresentasjon av objektet
    @Override
    public String toString() {
        return "Brett: " + burgere;
    }

    // Prøv å legge til en ny hamburger på brettet
    public synchronized boolean add(Kokk kokk) {
        if (burgere.size() < cap) {
            Hamburger burger = new Hamburger();
            burgere.add(burger);
            System.out.println(kokk + " legger på hamburger " + burger + ". " + this);
            if (servitorVenter.size() > 0) {
                servitorVenter.remove().wake();
            }
            return true;
        } else {
            kokkVenter.add(kokk);
            System.out.println(kokk + " er klar med hamburger, men brettet er fullt. Venter!");
            return false;
        }
    }

    // Prøv å ta en hamburger fra brettet
    public synchronized boolean pop(Servitor servitor) {
        if (burgere.size() > 0) {
            Hamburger burger = burgere.remove();
            System.out.println(servitor + " tar av hamburger " + burger + ". " + this);
            if (kokkVenter.size() > 0) {
                kokkVenter.remove().wake();
            }
            return true;
        } else {
            servitorVenter.add(servitor);
            System.out.println(servitor + " ønsker å ta en hamburger, men brettet er tomt. Venter!");
            return false;
        }
    }

}

package oppg3Alternativ;

public class Hamburger {
    private static int num = 0;
    private int id;

    // Konstruktør
    public Hamburger() {
        this.id = Hamburger.num++;;
    }

    // Strengrepresentasjon av objektet
    @Override
    public String toString() {
        return "◖" + id + "◗";
    }
}
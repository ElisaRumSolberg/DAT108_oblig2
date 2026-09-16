package oppg2;

public class Oppg2 {

    public static void main(String[] args) {
        HamburgerBrett brett = new HamburgerBrett(4);
        new Kokk("Anne", brett);
        new Kokk("Erik", brett);
        new Kokk("Knut", brett);
        new Servitor("Mia", brett);
        new Servitor("Per", brett);
    }
}

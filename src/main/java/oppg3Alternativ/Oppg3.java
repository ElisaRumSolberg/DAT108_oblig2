package oppg3Alternativ;

public class Oppg3 {

    public static void main(String[] args) {
        HamburgerBrett brett = new HamburgerBrett(8);
        new Kokk("Anne", brett);
        new Kokk("Erik", brett);
        new Kokk("Knut", brett);
        new Servitor("Mia", brett);
        new Servitor("Per", brett);
    }
}

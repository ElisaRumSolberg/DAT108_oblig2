public class Oppg2 {

    public static void main(String[] args) {

        final int KAPASITET = 4;

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        Kokk k1 = new Kokk(brett, "Anne");
        Kokk k2 = new Kokk(brett, "Erik");
        Kokk k3 = new Kokk(brett, "Knut");

        Servitor s1 = new Servitor(brett, "Mia");
        Servitor s2 = new Servitor(brett, "Per");

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
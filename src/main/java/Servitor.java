import java.util.Random;

public class Servitor extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (true) {

            try {
                int ventetid = random.nextInt(5) + 2;

                Thread.sleep(ventetid * 1000);

                brett.taAv(navn);

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
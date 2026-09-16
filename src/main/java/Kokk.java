import java.util.Random;

public class Kokk extends Thread {

    private HamburgerBrett brett;
    private String navn;

    public Kokk(HamburgerBrett brett, String navn) {
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

                brett.leggPa(navn);

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
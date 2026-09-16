import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ServitorBQ extends Thread {

    private BlockingQueue<HamburgerBQ> brett;
    private String navn;

    public ServitorBQ(BlockingQueue<HamburgerBQ> brett, String navn) {
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

                HamburgerBQ hamburger = brett.take();

                System.out.println(
                        navn
                                + " (servitør) tar av hamburger "
                                + hamburger
                                + ". Brett: "
                                + brett
                );

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
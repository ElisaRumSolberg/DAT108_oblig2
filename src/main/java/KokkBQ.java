
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class KokkBQ extends Thread {

    private BlockingQueue<HamburgerBQ> brett;
    private String navn;

    private static AtomicInteger nesteNummer = new AtomicInteger(1);

    public KokkBQ(BlockingQueue<HamburgerBQ> brett, String navn) {
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

                HamburgerBQ hamburger =
                        new HamburgerBQ(nesteNummer.getAndIncrement());

                brett.put(hamburger);

                System.out.println(
                        navn
                                + " (kokk) legger på hamburger "
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
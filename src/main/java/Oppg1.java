import javax.swing.JOptionPane;

public class Oppg1 {

    private static volatile String melding = "Hallo verden!";
    private static volatile boolean running = true;

    public static void main(String[] args) {

        System.out.println("Oppgave 1 - Tråder med System.out.println og JOptionPane");

        Thread utskriftTraad = new Thread(() -> {

            while (running) {

                System.out.println(melding);

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });


        Thread inputTraad = new Thread(() -> {

            while (running) {

                String nyMelding = JOptionPane.showInputDialog(
                        "Skriv inn en ny melding." +
                                "\nSkriv 'quit' for å avslutte:"
                );

                if (nyMelding == null || nyMelding.equalsIgnoreCase("quit")) {
                    running = false;
                    utskriftTraad.interrupt();
                    break;
                }

                melding = nyMelding;
            }
        });


        utskriftTraad.start();
        inputTraad.start();
    }
}
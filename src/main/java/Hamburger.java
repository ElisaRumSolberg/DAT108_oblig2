public class Hamburger {

    private int nummer;

    public Hamburger(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }

    @Override
    public String toString() {
        return "◖" + nummer + "◗";
    }
}
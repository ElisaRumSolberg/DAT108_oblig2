package oppg3;

public class HamburgerBQ {

    private int nummer;

    public HamburgerBQ(int nummer) {
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
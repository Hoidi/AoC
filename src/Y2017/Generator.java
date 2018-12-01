package Y2017;

public class Generator {

    private long value;
    private int factor;
    private int div = 2147483647;
    private int divisible;

    public Generator(int startingValue, int factor, int divisible) {
        value = startingValue;
        this.factor = factor;
        this.divisible = divisible;
    }

    public long generateNextValue() {
        do {
            xd();
        } while(value % divisible != 0);

        return value;
    }

    private void xd() {
        value = (value*factor) % div;
    }
}

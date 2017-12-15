public class Generator {

    private int value;
    private int factor;
    private int div = 2147483647;

    public Generator(int startingValue, int factor) {
        value = startingValue;
        this.factor = factor;
    }

    public int generateNextValue() {
        value = (value*factor) % div;

    }
}

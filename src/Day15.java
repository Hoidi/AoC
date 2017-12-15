public class Day15 {

    public static void main(String[] args) {
        int reult = countPairs();

        System.out.println(reult);

    }

    private static int countPairs() {
        Generator genA = new Generator(289,16807);
        Generator genB = new Generator(629,48271);
        int score = 0;

        int genTimes = 40000000;
        int valueA = 0;
        int valueB = 0;

        for(int i = 0; i < genTimes; i++) {
            valueA = genA.generateNextValue();
            valueB = genB.generateNextValue();

            // 2^16 = 65536

            // TODO: Does the first 16 bits match? Then do score++
            // Convert to binary. Divide my 2^16 and check if the remainder is equal
        }

        return score;
    }
}

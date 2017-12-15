public class Day15 {

    public static void main(String[] args) {
        int reult = countPairs();

        System.out.println(reult);

    }

    private static int countPairs() {

        Generator testgenA = new Generator(65,16807,4);
        Generator testgenB = new Generator(8921,48271,8);

        Generator genA = new Generator(289,16807,4);
        Generator genB = new Generator(629,48271,8);
        int score = 0;

        int genTimes = 5000000;//40000000;
        long valueA = 0;
        long valueB = 0;

        for(int i = 0; i < genTimes; i++) {
            valueA = genA.generateNextValue();
            valueB = genB.generateNextValue();

            // 2^16 = 65536

            int bin = 0b1111111111111111;

            if((valueA & bin) == (valueB & bin)) {
                score++;
            }
        }

        return score;
    }
}

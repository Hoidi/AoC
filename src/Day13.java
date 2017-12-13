import java.util.*;

public class Day13 {

    public static void main(String[] args) {
        Map<Integer,boolean[]> input = createMap();

        int result = jumpThrough(input, 0);
        int result2;
        int i = 10;
        while(true) {
            if(jumpThrough(createMap(),i) == 0) {
                result2 = i;
                break;
            }
            i++;
        }


        System.out.println("part 1: " + result);
        System.out.println("part 2: " + result2);
    }

    private static int jumpThrough(Map<Integer,boolean[]> map, int delay) {
        int step = 0;
        int score = 0;
        int picoSec = delay;
        int maxEntry = findMaxMap(map);
        setTrue(map);

        while(picoSec > 0) {
            nextTrue(map);
            picoSec--;
        }

        while (step <= maxEntry) {     // Ends when you've stepped out of the map
            //System.out.println("step: " + step);
            if(map.containsKey(step) && map.get(step)[1]) {
                score += (map.get(step).length-1)*step;
                //System.out.println("score: " + score + " updated");
            }

            nextTrue(map);
            step++;
            picoSec++;
        }
        if(score != 2 && score < 100 && delay > 100000) System.out.println("Score: " + score +
                "\n" +
                "Delay; " +
                delay);
        return score;
    }

    private static int findMaxMap(Map<Integer,boolean[]> map) {
        int maxEntry = 0;
        for (Integer key : map.keySet()) {
            if (maxEntry < key) {
                maxEntry = key;
            }
        }
        return maxEntry;
    }

    private static void setTrue(Map<Integer,boolean[]> map) {
        for (Integer key : map.keySet()) {
            map.get(key)[1] = true;
        }
    }

    private static void nextTrue(Map<Integer,boolean[]> map) {
        for (Integer key : map.keySet()) {
            int trueIndex = 1;
            boolean[] bolArr = map.get(key);
            for(int i = 1; i < bolArr.length; i++) {
                if(bolArr[i]) {
                    trueIndex = i;
                }
            }
            if(!bolArr[0]) {    // If false: move down one step
                bolArr[trueIndex] = false;
                bolArr[trueIndex + 1] = true;
            } else {            // If true: move up one step
                bolArr[trueIndex] = false;
                bolArr[trueIndex - 1] = true;
            }

            if(bolArr[bolArr.length-1] || bolArr[1]) { // Reached the end or beginning: flip
                // direction
                bolArr[0] = !bolArr[0];
            }
        }

    }

    private static Map<Integer,boolean[]> createMap() {
        String test1 = "0: 3\n" +
                       "1: 2\n" +
                       "4: 4\n" +
                       "6: 4";      // 24 answer

        String start = "0: 4\n" +
                "1: 2\n" +
                "2: 3\n" +
                "4: 4\n" +
                "6: 8\n" +
                "8: 5\n" +
                "10: 8\n" +
                "12: 6\n" +
                "14: 6\n" +
                "16: 8\n" +
                "18: 6\n" +
                "20: 6\n" +
                "22: 12\n" +
                "24: 12\n" +
                "26: 10\n" +
                "28: 8\n" +
                "30: 12\n" +
                "32: 8\n" +
                "34: 12\n" +
                "36: 9\n" +
                "38: 12\n" +
                "40: 8\n" +
                "42: 12\n" +
                "44: 17\n" +
                "46: 14\n" +
                "48: 12\n" +
                "50: 10\n" +
                "52: 20\n" +
                "54: 12\n" +
                "56: 14\n" +
                "58: 14\n" +
                "60: 14\n" +
                "62: 12\n" +
                "64: 14\n" +
                "66: 14\n" +
                "68: 14\n" +
                "70: 14\n" +
                "72: 12\n" +
                "74: 14\n" +
                "76: 14\n" +
                "80: 14\n" +
                "84: 18\n" +
                "88: 14\n";

        String[] halfwayThere = start.split("\n");

        String[][] matrix = new String[halfwayThere.length][];
        int r = 0;
        for (String row : halfwayThere) {
            matrix[r++] = row.split(": ");
        }

        Map<Integer,boolean[]> map = new HashMap<>();

        // Created map of integers in arr
        for(int i = 0; i < matrix.length; i++) {
            int currentInt = Integer.parseInt(matrix[i][0]);
            int currentBol = Integer.parseInt(matrix[i][1]);
            if(!map.containsKey(currentInt)) {
                map.put(currentInt, new boolean[currentBol+1]);
                // +1 for boolean that decides direction of true is going
                // false is up true is down
            }
        }

        return map;
    }
}

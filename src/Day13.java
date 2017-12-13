import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 {

    public static void main(String[] args) {
        Map<Integer,boolean[]> input = createMap();

    }

    private static Map<Integer,boolean[]> createMap() {
        String start = "0: 3\n" +
                       "1: 2\n" +
                       "4: 4\n" +
                       "6: 4";

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
                map.put(currentInt, new boolean[currentBol]);
            }
        }

        /*
        int maxValueArr = Integer.parseInt(matrix[matrix.length-1][0]);
        for(int i = 0; i < maxValueArr; i++) {
            if(!map.containsKey(i)) {
                map.put(i, new boolean[0]);
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            int currentInt = Integer.parseInt(matrix[i][0]);
            int currentBol = Integer.parseInt(matrix[i][1]);
            if(map.containsKey(currentInt)) {
                map.replace(currentInt,new boolean[currentBol]);
            }
        }*/

        return map;
    }
}

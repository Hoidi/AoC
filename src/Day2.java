import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},
                        {2,5,6}};

        try {
            URL url = new URL("http://adventofcode.com/2017/day/2/input");
            Scanner s = new Scanner(url.openStream());
            System.out.println(s);
            // read from your scanner
        }
        catch(IOException ex) {
            // there was some connection problem, or the file did not exist on the server,
            // or your URL was not in the right format.
            // think about what to do now, and put it here.
            System.out.println("rip file");
            ex.printStackTrace(); // for now, simply output it.
        }

        int result1 = differenceSum(input);

        System.out.println(result1);
    }
    
    private static int differenceSum(int[][] matrix) {
        int result = 0;

        for (int row = 0; row < matrix.length; row++) {
            int max = matrix[row][1];
            int min = matrix[row][1];
            for (int col = 0; col < matrix[row].length; col++) {
                int thisPosition = matrix[row][col];
                if (thisPosition < min) {
                    min = thisPosition;
                }
                if (thisPosition > max) {
                    max = thisPosition;
                }
            }
            result += max - min;

        }
        return result;
    }

    private static int[][] createMatrix(String s) {
        return null;
    }
}

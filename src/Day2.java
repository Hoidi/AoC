public class Day2 {

    public static void main(String[] args) {
        int[][] input = {{1,2,3,4},
                        {2,5,6}};

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
}

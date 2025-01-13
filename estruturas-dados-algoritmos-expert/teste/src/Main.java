import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int sum = 0;
//        for (int[] row : matrix) {
//            for (int num : row) {
//                sum += num;
//            }
//        }
        int sum = Arrays.stream(matrix).flatMapToInt(Arrays::stream).reduce(0, Integer::sum);
//      double average = (double) sum / (matrix.length * matrix[0].length);
        double average = Arrays.stream(matrix).flatMapToInt(Arrays::stream).average().orElse(0.0);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}

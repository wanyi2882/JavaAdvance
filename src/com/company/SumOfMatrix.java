package com.company;
import java.util.*;

public class SumOfMatrix {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = initializeMatrix(sc, matrixDimensions);

        int sum = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                sum += matrix[row][col];
            }
        }

        System.out.println(matrixDimensions[0]);
        System.out.println(matrixDimensions[1]);
        System.out.println(sum);
    }

    private static int[][] initializeMatrix(Scanner sc, int[] firstMatrixDimensions) {
        int rows = firstMatrixDimensions[0];
        int columns = firstMatrixDimensions[1];

        int[][] matrix = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            int[] array = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = array;
        }
        return  matrix;
    }

}

package com.company;
import java.util.*;

public class MaxSumOf2By2 {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = initializeMatrix(sc, matrixDimensions);
        int[][] result = new int[2][2];

        int maxSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;

        for(int row = 0; row < matrix.length - 1; row++){
            for(int col = 0; col < matrix[row].length -1; col++){
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if(sum > maxSum){
                    maxSum = sum;
                    result[0][0] = matrix[row][col];
                    result[0][1] = matrix[row][col + 1];
                    result[1][0] = matrix[row + 1][col];
                    result[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        System.out.println(result[0][0] + " " + result[0][1]);
        System.out.println(result[1][0] + " " + result[1][1]);
        System.out.println(maxSum);
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

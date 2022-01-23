package com.company;
import java.util.*;

public class Palindromes {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = initializeMatrix(matrixDimensions);

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] initializeMatrix(int[] firstMatrixDimensions) {
        int rows = firstMatrixDimensions[0];
        int columns = firstMatrixDimensions[1];

        String[][] matrix = new String[rows][columns];

        for(int i = 0; i < rows; i++){
            String[] array = new String[columns];
            int start = 97;

            char one = (char) (start + i);

            array[0] = "" + one + one + one;

            for(int j = 1; j < columns; j++){

                char two = (char) (start + j + i);

                array[j] = "" + one + two + one;
            }
            matrix[i] = array;
        }
        return matrix;
    }
}

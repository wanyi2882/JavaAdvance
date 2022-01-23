package com.company;
import java.util.*;

public class PositionMatrix {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = initializeMatrix(sc, matrixDimensions);

        int numberToFind = Integer.parseInt(sc.nextLine());

        int count = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                if(matrix[row][col] == numberToFind){
                    count++;
                    System.out.println(row + " " + col);
                }
            }
        }

        if(count == 0){
            System.out.println("not found");
        }
    }

    private static int[][] initializeMatrix(Scanner sc, int[] firstMatrixDimensions) {
        int rows = firstMatrixDimensions[0];
        int columns = firstMatrixDimensions[1];

        int[][] matrix = new int[rows][columns];

        for(int i = 0; i < rows; i++){
            int[] array = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = array;
        }
        return  matrix;
    }
}

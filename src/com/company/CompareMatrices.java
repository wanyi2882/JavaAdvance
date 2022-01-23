package com.company;
import java.util.*;

public class CompareMatrices {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int[] firstMatrixDimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] firstMatrix = initializeMatrix(sc, firstMatrixDimensions);

        int[] secondMatrixDimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] secondMatrix = initializeMatrix(sc, secondMatrixDimensions);

        String output;

        if(matricesAreEqual(firstMatrix, secondMatrix)){
            output = "equal";
        } else {
            output = "not equal";
        }

        System.out.println(output);

    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix){
        if(firstMatrix.length != secondMatrix.length){
            return false;
        }

        for(int row = 0; row < firstMatrix.length; row++){
            if(firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }

            for(int column = 0; column < firstMatrix[row].length; column++){
                if(firstMatrix[row][column] != secondMatrix[row][column]){
                    return  false;
                }
            }
        }
        return true;
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

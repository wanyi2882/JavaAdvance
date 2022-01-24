package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Revolt {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(bfr.readLine());

        int numberOfCommands = Integer.parseInt(bfr.readLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        int playerRow = 0;
        int playerCol = 0;

        int finishRow = 0;
        int finishCol = 0;

        for( int row = 0; row < matrix.length; row++){
            char[] elements = bfr.readLine().toCharArray();
            for(int col = 0; col < matrix[row].length; col++){
                if(elements[col] == 'f'){
                    playerRow = row;
                    playerCol = col;
                } else if (elements[col] == 'F'){
                    finishRow = row;
                    finishCol = col;
                }
                matrix[row][col] = elements[col];
            }
        }

        for(int i = 0; i < numberOfCommands; i++){
            String direction = bfr.readLine();
            matrix[playerRow][playerCol] = '+';

            switch (direction) {
                case "up":
                    if(!isInRange(playerRow - 1, playerCol, matrix)){
                        playerRow = matrixSize - 1;
                    } else {
                        playerRow--;
                    }

                    if(isOnTrap(playerRow, playerCol, matrix)) {
                        if(!isInRange(playerRow + 1, playerCol, matrix)){
                            playerRow = 0;
                        } else {
                            playerRow++;
                        }
                    }

                    if(isOnBonus(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow - 1, playerCol, matrix)){
                            playerRow = matrixSize - 1;
                        } else {
                            playerRow--;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    if(isOnFinish(playerRow, playerCol, finishRow, finishCol)){
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }

                    break;
                case "down":
                    if(!isInRange(playerRow + 1, playerCol, matrix)){
                        playerRow = 0;
                    } else {
                        playerRow++;
                    }

                    if(isOnTrap(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow - 1, playerCol, matrix)){
                            playerRow = matrixSize - 1;
                        } else {
                            playerRow--;
                        }
                    }

                    if(isOnBonus(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow + 1, playerCol, matrix)) {
                            playerRow = 0;
                        } else {
                            playerRow++;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    if(isOnFinish(playerRow, playerCol, finishRow, finishCol)){
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }

                    break;
                case "left":

                    if(!isInRange(playerRow, playerCol - 1, matrix)){
                        playerCol = matrix[playerRow].length - 1;
                    } else {
                        playerCol--;
                    }

                    if(isOnTrap(playerRow, playerCol, matrix)) {
                        if(!isInRange(playerRow, playerCol + 1, matrix)){
                            playerCol = 0;
                        } else {
                            playerCol++;
                        }
                    }

                    if(isOnBonus(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow, playerCol - 1, matrix)){
                            playerCol = matrix[playerRow].length - 1;
                        } else {
                            playerCol--;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    if(isOnFinish(playerRow, playerCol, finishRow, finishCol)){
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }

                    break;
                case "right":

                    if(!isInRange(playerRow, playerCol + 1, matrix)){
                        playerCol = 0;
                    } else {
                        playerCol++;
                    }

                    if(isOnTrap(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow, playerCol - 1, matrix)){
                            playerCol = matrix[playerRow].length - 1;
                        } else {
                            playerCol--;
                        }
                    }

                    if(isOnBonus(playerRow, playerCol, matrix)){
                        if(!isInRange(playerRow, playerCol + 1, matrix)) {
                            playerCol = 0;
                        } else {
                            playerCol++;
                        }
                    }

                    matrix[playerRow][playerCol] = 'f';

                    if(isOnFinish(playerRow, playerCol, finishRow, finishCol)){
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }

                    break;
            }
        }

        System.out.println("Player lost!");
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOnFinish(int playerRow, int playerCol, int finishRow, int finishCol) {
        return (playerRow == finishRow)&& (playerCol == finishCol);
    }

    private static boolean isOnBonus(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'B';
    }
    private static boolean isOnTrap(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'T';
    }

    private static boolean isInRange(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {
    public static void main(String[] args) throws IOException {
        // Write your code here
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(bfr.readLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        int playerRow = 0;
        int playerCol = 0;
        int pollinatedFlowers = 0;

        for( int row = 0; row < matrix.length; row++){
            char[] elements = bfr.readLine().toCharArray();
            for(int col = 0; col < matrix[row].length; col++){
                if(elements[col] == 'B'){
                    playerRow = row;
                    playerCol = col;
                }
                matrix[row][col] = elements[col];
            }
        }

        while(true){
            String command = bfr.readLine();

            if(command.equals("End")){
                checkPollination(pollinatedFlowers);
                printMatrix(matrix);
                break;
            }

            matrix[playerRow][playerCol] = '.';

            if(command.equals("up")) {
                playerRow--;
                if (!isInRange(playerRow, playerCol, matrix)) {
                    isLost();
                    checkPollination(pollinatedFlowers);
                    printMatrix(matrix);
                    break;
                }
                else if (isOnFlower(playerRow, playerCol, matrix)) {
                    pollinatedFlowers++;
                    matrix[playerRow][playerCol] = 'B';
                }
                else if (isOnBonus(playerRow, playerCol, matrix)) {
                    matrix[playerRow][playerCol] = '.';
                    playerRow--;
                    if (isOnFlower(playerRow, playerCol, matrix)) {
                        pollinatedFlowers++;
                        matrix[playerRow][playerCol] = 'B';
                    }
                    else{
                        matrix[playerRow][playerCol] = 'B';
                    }
                }
                else {
                    matrix[playerRow][playerCol] = 'B';
                }
            } else if (command.equals("down")) {
                playerRow++;
                if (!isInRange(playerRow, playerCol, matrix)) {
                    isLost();
                    checkPollination(pollinatedFlowers);
                    printMatrix(matrix);
                    break;
                }
                else if (isOnFlower(playerRow, playerCol, matrix)) {
                    pollinatedFlowers++;
                    matrix[playerRow][playerCol] = 'B';
                }
                else if (isOnBonus(playerRow, playerCol, matrix)) {
                    matrix[playerRow][playerCol] = '.';
                    playerRow++;
                    if (isOnFlower(playerRow, playerCol, matrix)) {
                        pollinatedFlowers++;
                        matrix[playerRow][playerCol] = 'B';
                    }
                    else{
                        matrix[playerRow][playerCol] = 'B';
                    }
                }
                else {
                    matrix[playerRow][playerCol] = 'B';
                }
            } else if(command.equals("left")) {
                playerCol--;
                if (!isInRange(playerRow, playerCol, matrix)) {
                    isLost();
                    checkPollination(pollinatedFlowers);
                    printMatrix(matrix);
                    break;
                } else if (isOnFlower(playerRow, playerCol, matrix)) {
                    pollinatedFlowers++;
                    matrix[playerRow][playerCol] = 'B';
                } else if (isOnBonus(playerRow, playerCol, matrix)) {
                    matrix[playerRow][playerCol] = '.';
                    playerCol--;
                    if (isOnFlower(playerRow, playerCol, matrix)) {
                        pollinatedFlowers++;
                        matrix[playerRow][playerCol] = 'B';
                    } else {
                        matrix[playerRow][playerCol] = 'B';
                    }
                } else {
                    matrix[playerRow][playerCol] = 'B';
                }
            } else if(command.equals("right")) {
                playerCol++;
                if (!isInRange(playerRow, playerCol, matrix)) {
                    isLost();
                    checkPollination(pollinatedFlowers);
                    printMatrix(matrix);
                    break;
                } else if (isOnFlower(playerRow, playerCol, matrix)) {
                    pollinatedFlowers++;
                    matrix[playerRow][playerCol] = 'B';
                } else if (isOnBonus(playerRow, playerCol, matrix)) {
                    matrix[playerRow][playerCol] = '.';
                    playerCol++;
                    if (isOnFlower(playerRow, playerCol, matrix)) {
                        pollinatedFlowers++;
                        matrix[playerRow][playerCol] = 'B';
                    } else {
                        matrix[playerRow][playerCol] = 'B';
                    }
                } else {
                    matrix[playerRow][playerCol] = 'B';
                }
            }
        }
    }

    private static void checkPollination(int pollinatedFlowers) {
        if(pollinatedFlowers >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }
        else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
    }

    private static void isLost() {
        System.out.println("The bee got lost!");
    }

    private static boolean isInRange(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    private static boolean isOnFlower(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'f';
    }
    private static boolean isOnBonus(int playerRow, int playerCol, char[][] matrix) {
        return matrix[playerRow][playerCol] == 'O';
    }

    private static void printMatrix(char[][] matrix) {
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

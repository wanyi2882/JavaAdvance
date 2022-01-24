package com.company;

import java.io.*;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPathOne = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/inputOne.txt";
        String inputPathTwo = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/inputTwo.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/output.txt";

        Scanner scannerOne = new Scanner(new FileInputStream(inputPathOne));
        Scanner scannerTwo = new Scanner(new FileInputStream(inputPathTwo));

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));

        while(scannerOne.hasNext()){
            printWriter.println(scannerOne.next());
        }
        while(scannerTwo.hasNext()){
            printWriter.println(scannerTwo.next());
        }
        printWriter.close();

    }
}

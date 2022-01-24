package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws FileNotFoundException{
        String inputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));

        PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputPath));

        while(scanner.hasNext()){
            if(scanner.hasNextInt()){
                printWriter.println(scanner.nextInt());
            }
            scanner.next();
        }
        printWriter.close();
    }
}

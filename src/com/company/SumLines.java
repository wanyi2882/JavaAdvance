package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        String path = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/input.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();

            while(line != null){
                int sum = 0;

                for(int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    sum += character;
                }

                System.out.println(sum);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

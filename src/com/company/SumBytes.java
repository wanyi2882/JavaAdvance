package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) {
        String path = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/input.txt";

        long sum = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();

            while(line != null){
                for(int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    sum += character;
                }

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sum);
    }
}

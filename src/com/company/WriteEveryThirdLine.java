package com.company;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args){
        String inputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))){
            int counter = 1;
            String line = bufferedReader.readLine();

            while(line != null){

                if(counter % 3 == 0){
                    printWriter.println(line);
                }
                counter++;
                line = bufferedReader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

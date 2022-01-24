package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyStream {
    public static void main(String[] args){
        String inputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt";

        try(FileInputStream inputStream = new FileInputStream(inputPath);
            FileOutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = 0;

            while((oneByte =inputStream.read()) >= 0){
                if(oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);

                    for(int i = 0; i < digits.length(); i++){
                        outputStream.write(digits.charAt(i));
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args){
        String path = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try(FileInputStream inputStream = new FileInputStream(path);
            OutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = 0;

            while((oneByte = inputStream.read()) >= 0){
                if(!symbols.contains((char)oneByte)){
                    outputStream.write(oneByte);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
package com.company;

import java.io.File;

public class FolderSize {
    public static void main(String[] args) {
        File file = new File("/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/Exercises Resources");

        int sum = 0;

        if(file.exists()){
            File[] files = file.listFiles();

            for(File f : files){
                sum += f.length();
            }
        }

        System.out.println("Folder size: " + sum);
    }
}

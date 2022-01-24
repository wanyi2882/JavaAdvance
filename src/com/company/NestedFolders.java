package com.company;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {

        String pathRoot = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";

        File root = new File(pathRoot);

        Deque<File> directories = new ArrayDeque<>();

        directories.offer(root);

        int count = 0;

        while(!directories.isEmpty()){
            File current = directories.poll();
            System.out.println(current.getName());
            File[] nestedFiles = current.listFiles();

            for(File nestedFile : nestedFiles){
                if(nestedFile.isDirectory()){
                    directories.offer(nestedFile);
                }
            }

            count++;
        }
        System.out.println(count + " folders");
    }
}

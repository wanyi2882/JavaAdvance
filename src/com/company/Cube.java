package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cube implements Serializable {
    private String color;
    private double width;
    private double height;
    private double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3, 12.4, 3);

        String path="/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/serialization.txt";

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(cube);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

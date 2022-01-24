package com.company;

import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) {
        try {
            FileInputStream readData = new FileInputStream("list.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            ArrayList<Double> numbersDsl = (ArrayList<Double>) readStream.readObject();
            readStream.close();

            System.out.println(numbersDsl.toString());

        } catch (Exception e) {
            System.out.println("An error occurred. 😿");
            e.printStackTrace();
        }

        // Serialization
//        ArrayList<Double> numbers = new ArrayList<>();
//
//        numbers.add(46.2);
//        numbers.add(32.5);
//        numbers.add(11.7);
//
//        try {
//            FileOutputStream writeData = new FileOutputStream("list.ser");
//            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
//
//            writeStream.writeObject(numbers);
//            writeStream.flush();
//            writeStream.close();
//
//            System.out.println("The ArrayList was serialized successfully! 😎");
//
//        } catch (IOException e) {
//            System.out.println("An error occurred. 😿");
//            e.printStackTrace();
//        }
    }

}

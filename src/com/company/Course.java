package com.company;

import java.io.*;

public class Course implements Serializable {
    private String name;
    private int studentsCount;

    public Course(String name, int studentsCount) {
        this.name = name;
        this.studentsCount = studentsCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentsCount() {
        return this.studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return new StringBuffer("Course name: ")
                .append(this.name)
                .append(", Students enrolled: ")
                .append(this.studentsCount)
                .toString();
    }

    public static void main(String[] args) {

        // Serialization
        //Course courseOne = new Course("Programming with Python",  32);

        //try {
        //    FileOutputStream fileOut = new FileOutputStream("course.ser");
        //    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        //    objectOut.writeObject(courseOne);
        //    objectOut.close();

        //    System.out.println("The object was succesfully written to a file! ☑️");

        //} catch (Exception e) {
        //    System.out.println("An error occurred. 😵");
        //    e.printStackTrace();
        //}

        Course courseDsl;

        try {
            FileInputStream fileIn = new FileInputStream("course.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            courseDsl = (Course) in.readObject();

            in.close();
            fileIn.close();

            System.out.println(courseDsl.toString());

        } catch (Exception e) {
            System.out.println("An exception occurred. 😾");
            e.printStackTrace();
        }
    }
}

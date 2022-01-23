package com.company;
import java.util.*;

public class TryFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Code executed before try-finally.");
        try {
            String str = sc.nextLine();
            Integer.parseInt(str);
            System.out.println("Parsing was successful.");
            return; // Exit from the current method
        } catch (NumberFormatException ex) {
            System.out.println("Parsing failed!");
        } finally {
            System.out.println("This cleanup code is always executed.");
        }
        System.out.println("This code is after the try-finally block.");
    }
}

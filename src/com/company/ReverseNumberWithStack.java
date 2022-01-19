package com.company;
import java.util.*;

public class ReverseNumberWithStack {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");

        ArrayDeque<Integer> integerArrayDeque = new ArrayDeque<>();

        for(int i = 0; i < array.length; i++){
            integerArrayDeque.push(Integer.parseInt(array[i]));
        }

        while(!integerArrayDeque.isEmpty()){
            System.out.print(integerArrayDeque.pop() + " ");
        }
    }
}

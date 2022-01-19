package com.company;
import java.util.*;

public class DecimalBinary {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int decimal = Integer.parseInt(sc.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if(decimal==0){
            System.out.println(decimal);
        }

        while(decimal != 0){
            stack.push(decimal % 2);
            decimal /= 2;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}

package com.company;
import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, tokens);

        while(stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch(operator) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;

                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}

package com.company;
import java.util.*;

public class MaxElement {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < N; i++){
            String[] commands = sc.nextLine().split("\\s+");

            if(commands[0].equals("1")){
                stack.push(Integer.parseInt(commands[1]));
            }
            else if(commands[0].equals("2")){
                stack.pop();
            }
            else if(commands[0].equals("3")){
                int largest = stack.peek();
                for(Integer x : stack){
                    if(x > largest){
                        largest = x;
                    }
                }
                System.out.println(largest);
            }
        }
    }
}

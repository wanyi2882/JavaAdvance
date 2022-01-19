package com.company;
import java.util.*;

public class BasicStack {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String[] inputs = sc.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int X = Integer.parseInt(inputs[2]);

        String[] integerArray = sc.nextLine().split("\\s+");
        for(int i = 0; i < N; i++){
            stack.push(Integer.parseInt(integerArray[i]));
        }

        for(int j = 0; j < S; j++){
            stack.pop();
        }

        if(stack.contains(X)){
            System.out.println(true);
        }
        else{
            while(stack.size() > 1){
                int first = stack.pop();
                int second = stack.pop();

               if(first < second){
                   stack.push(first);
               }
               else{
                   stack.push(second);
               }
            }

            System.out.println(stack.pop());
        }
    }
}

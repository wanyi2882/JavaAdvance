package com.company;
import java.util.*;

public class MathPotato {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String[] children = sc.nextLine().split(" ");

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for(String child : children){
            queue.offer(child);
        }

        int cycle = 1;

        while(queue.size() > 1){
            for(int i = 1; i < n; i++){
                queue.offer(queue.poll());
            }

            if(isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            }
            else{
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number){
        if(number == 1){
            return false;
        }
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return  false;
            }
        }
        return true;
    }
}
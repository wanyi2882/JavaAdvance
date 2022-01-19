package com.company;
import java.util.*;

public class HotPotato {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        String[] children = sc.nextLine().split(" ");

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for(String child : children){
            queue.offer(child);
        }

        while(queue.size() > 1){
            for(int i = 1; i < n; i++){
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}

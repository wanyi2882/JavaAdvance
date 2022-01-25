package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class FlowerWreath {
    public static void main(String[] args) throws IOException {
        // Write your code here
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] lilies = Arrays.stream(bfr.readLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] roses = Arrays.stream(bfr.readLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        for(int lily : lilies){
            liliesStack.push(lily);
        }

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        for(int rose : roses){
            rosesQueue.offer(rose);
        }

        int wreathDone = 0;
        int storedFlowers = 0;

        while(!liliesStack.isEmpty() && !rosesQueue.isEmpty()){

            if(liliesStack.peek() + rosesQueue.peek() < 15) {
                storedFlowers += liliesStack.pop();
                storedFlowers += rosesQueue.poll();
            }
            else if(liliesStack.peek() + rosesQueue.peek() > 15) {
                int currentLiliesCount = liliesStack.peek() - 2;

                while(currentLiliesCount + rosesQueue.peek() > 0){
                    if(currentLiliesCount + rosesQueue.peek() == 15) {
                        wreathDone++;
                        liliesStack.pop();
                        rosesQueue.poll();
                        break;
                    }
                    else if(currentLiliesCount + rosesQueue.peek() < 15) {
                        storedFlowers += liliesStack.pop() - 2;
                        storedFlowers += rosesQueue.poll();
                        break;
                    }
                    currentLiliesCount-=2;
                }

            }
            else if(liliesStack.peek() + rosesQueue.peek() == 15) {
                wreathDone++;
                liliesStack.pop();
                rosesQueue.poll();
            }
        }

        wreathDone += Math.floor(storedFlowers / 15.0);

        if(wreathDone >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreathDone);
        }
        else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathDone);
        }
    }
}

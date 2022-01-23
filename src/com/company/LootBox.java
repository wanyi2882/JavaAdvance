package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LootBox {
    public static void main(String[] args)  throws IOException {
        // Write your code here
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        Integer[] firstLootBox = Arrays.stream(bfr.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Integer[] secondLootBox = Arrays.stream(bfr.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        ArrayDeque<Integer> queueFirstLootBox = new ArrayDeque<>();

        for(Integer lootBox : firstLootBox){
            queueFirstLootBox.offer(lootBox);
        }

        ArrayDeque<Integer> stackSecondLootBox = new ArrayDeque<>();

        for(Integer lootBox : secondLootBox){
            stackSecondLootBox.push(lootBox);
        }

        List<Integer> claimedItems = new ArrayList<>();

        while(!queueFirstLootBox.isEmpty() && !stackSecondLootBox.isEmpty()){
            int result = queueFirstLootBox.peek() + stackSecondLootBox.peek();

            if(result % 2 == 0){
                claimedItems.add(result);

                queueFirstLootBox.poll();
                stackSecondLootBox.pop();
            } else {
                queueFirstLootBox.offer(stackSecondLootBox.pop());
            }
        }

        if(queueFirstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int collectedItemsSum = claimedItems.stream().mapToInt(Integer::intValue).sum();

        if(collectedItemsSum >= 100){
            System.out.printf("Your loot was epic! Value: %d", collectedItemsSum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", collectedItemsSum);
        }
    }
}

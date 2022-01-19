package com.company;

import java.util.*;

public class Plants {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] plants = sc.nextLine().split(" ");

        List<Integer> plantsList = new ArrayList<>();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        int daysPlantsDie = 0;

        for (int j = 0; j < plants.length; j++) {
            plantsList.add(Integer.parseInt(plants[j]));
        }

        int currentPlantListLength = plantsList.size();
        int afterPlantListLength = 0;

        while(currentPlantListLength != afterPlantListLength){
            currentPlantListLength = plantsList.size();

            for (int x = 1; x < plantsList.size(); x++) {
                if (plantsList.get(x) > plantsList.get(x - 1)) {
                    indexes.push(plantsList.get(x));
                }
            }

            while(indexes.size() != 0){
                int toRemove = indexes.pop();
                for(int y = 0; y < plantsList.size(); y++){
                    if(plantsList.get(y) == toRemove){
                        plantsList.remove(y);
                    }
                }
            }

            afterPlantListLength = plantsList.size();

            if(currentPlantListLength > afterPlantListLength){
                daysPlantsDie++;
            }
        }

        System.out.println(daysPlantsDie);
    }
}

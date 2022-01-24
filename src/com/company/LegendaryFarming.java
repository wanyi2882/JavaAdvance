package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        // Write your code here
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        boolean isItemObtained = false;

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("shards", 0);

        while(!isItemObtained){
            String input = bfr.readLine().toLowerCase();
            String[] tokens = input.split("\\s+");

            for(int i = 0; i < tokens.length; i+=2){
                if(tokens[i+1].equals("motes")){
                    int currentQuantity = keyMaterials.get("motes");
                    int newQuantity = currentQuantity + Integer.parseInt(tokens[i]);
                    keyMaterials.replace("motes", newQuantity);

                    isItemObtained = checkLegendary(keyMaterials);

                    if(isItemObtained){
                        break;
                    }
                }
                else if(tokens[i+1].equals("fragments")){
                    int currentQuantity = keyMaterials.get("fragments");
                    int newQuantity = currentQuantity + Integer.parseInt(tokens[i]);

                    keyMaterials.replace("fragments", newQuantity);

                    isItemObtained = checkLegendary(keyMaterials);

                    if(isItemObtained){
                        break;
                    }
                }
                else if(tokens[i+1].equals("shards")){
                    int currentQuantity = keyMaterials.get("shards");
                    int newQuantity = currentQuantity + Integer.parseInt(tokens[i]);

                    keyMaterials.replace("shards", newQuantity);

                    isItemObtained = checkLegendary(keyMaterials);

                    if(isItemObtained){
                        break;
                    }
                }
                else {
                    String junk = tokens[i+1];
                    int junkQuantity = Integer.parseInt(tokens[i]);
                    if(junkMaterials.containsKey(junk)){
                        int currentQuantity = junkMaterials.get(junk);
                        int newQuantity = currentQuantity + junkQuantity;

                        junkMaterials.replace(junk, newQuantity);
                    } else {
                        junkMaterials.put(junk, junkQuantity);
                    }
                }
            }
        }

        if(keyMaterials.get("motes") >= 250){
            System.out.println("Dragonwrath obtained!");
            keyMaterials.replace("motes", keyMaterials.get("motes") - 250);
            printResults(keyMaterials, junkMaterials);
        }
        else if(keyMaterials.get("fragments") >= 250){
            System.out.println("Valanyr obtained!");
            keyMaterials.replace("fragments", keyMaterials.get("fragments") - 250);
            printResults(keyMaterials, junkMaterials);
        }
        else if(keyMaterials.get("shards") >= 250){
            System.out.println("Shadowmourne obtained!");
            keyMaterials.replace("shards", keyMaterials.get("shards") - 250);
            printResults(keyMaterials, junkMaterials);
        }
    }

    private static boolean checkLegendary(Map<String, Integer> keyMaterials) {
        if(keyMaterials.get("motes") >= 250
                || keyMaterials.get("fragments") >= 250
                || keyMaterials.get("shards") >= 250){
            return true;
        }
        return false;
    }

    private static void printResults(Map<String, Integer> keyMaterials, Map<String, Integer> junkMaterials) {
        keyMaterials.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int results = b.getValue().compareTo(a.getValue());

                    if(results == 0) {
                        results = a.getKey().compareTo(b.getKey());
                    }
                    return results;
                })
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkMaterials.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}

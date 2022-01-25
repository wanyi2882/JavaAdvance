package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        // Write your code here
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Long>> populationByCountryCity = new LinkedHashMap<>();
        LinkedHashMap<String, Long> populationByCountry = new LinkedHashMap<>();

        while (true) {
            String command = bfr.readLine();

            if (command.equals("report")) {
                populationByCountryCity.entrySet()
                        .stream()
                        .sorted((countryOne, countryTwo) ->
                                populationByCountry.get(countryTwo.getKey()).compareTo(populationByCountry.get(countryOne.getKey())))
                        .forEach(country -> {
                            System.out.printf("%s (total population: %d)%n", country.getKey(), populationByCountry.get(country.getKey()));
                            country.getValue().entrySet()
                                    .stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                                    .forEach(city -> {
                                        System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                                    });
                        });
                break;

            } else {
                String[] populationArray = command.split("\\|");
                String city = populationArray[0];
                String country = populationArray[1];
                long population = Long.parseLong(populationArray[2]);

                populationByCountryCity.putIfAbsent(country, new LinkedHashMap<>());

                if(populationByCountryCity.containsKey(country)){
                    populationByCountryCity.get(country).put(city, population);
                }

                if (populationByCountry.containsKey(country)) {
                    long currentPopulation = populationByCountry.get(country);
                    populationByCountry.replace(country, currentPopulation + population);
                } else {
                    populationByCountry.put(country, population);
                }
            }
        }
    }
}

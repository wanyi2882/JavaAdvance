package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        String inputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/wanyi/Documents/Java Advance/out/resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt";

        try {
            List<String> lines = Files.readAllLines(Path.of(inputPath));

            lines = lines.stream().filter( l -> !l.isBlank()).collect(Collectors.toList());

            Collections.sort(lines);

            Files.write(Path.of(outputPath), lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

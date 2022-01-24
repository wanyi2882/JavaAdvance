package com.company;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String zipFile = "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/files.zip";

        String[] sourceFiles = { "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/fileOne.txt",
                "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/fileTwo.txt",
                "/Users/wanyi/Documents/Java Advance/out/resources/04-Java-Advanced-Files-and-Streams-Exercise-Resources/fileThree.txt"
        };

        try {
            // Create a byte[] buffer
            byte[] buffer = new byte[1024];

            FileOutputStream fileOut = new FileOutputStream(zipFile);

            ZipOutputStream zipOut = new ZipOutputStream(fileOut);

            for (int i=0; i < sourceFiles.length; i++) {

                File sourceFile = new File(sourceFiles[i]);

                FileInputStream fileIn = new FileInputStream(sourceFile);

                // Start writing a new ZIP entry
                // Positioning the stream to the start of the entry data
                zipOut.putNextEntry(new ZipEntry(sourceFile.getName()));

                int length;

                while ((length = fileIn.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }

                zipOut.closeEntry();

                // Closing the InputStream
                fileIn.close();

            }

            // Closing the ZipOutputStream
            zipOut.close();

            System.out.println("The zip file was created successfully. 👏");


        }
        catch (IOException e) {
            System.out.println("There was an error creating the file. 😨");
        }

    }
}

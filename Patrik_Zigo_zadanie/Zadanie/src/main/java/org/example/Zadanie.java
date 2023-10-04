package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie {
    public static void main(String[] args) throws IOException {
        application();
    }

    public static void application() throws IOException {
        System.out.println("Choose one and press 'ENTER':\n" +
                "1- Write your numbers in console and output is also in console. \n" +
                "2- Load numbers from file and output will be in console. \n" +
                "3- Load numbers from file and output will be in output.txt file.");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> readFromConsoleAndWriteToConsole();
            case 2 -> readFromFileWriteToConsole();
            case 3 -> readFromFileWriteToFile();
        }
    }

    public static void readFromConsoleAndWriteToConsole() {
        List<Integer> output = new ArrayList<>();
        System.out.println("Write numbers separate by 'SPACE', after you finished press 'ENTER'");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(" ");

        for (String number : numbers) {
            int helper = Integer.parseInt(number);
            if ((helper % 2 == 0 && numbers.length % 2 == 0) || (helper % 2 == 1 && numbers.length % 2 != 0)) {
                output.add(helper);
            }
        }
        System.out.println("Your output is " + output);
    }

    public static void readFromFileWriteToConsole() throws IOException {
        try {
            Path inputFilePath = Path.of("input.txt");
            List<String> allLinesFromInput = Files.readAllLines(inputFilePath);
            List<Integer> validNumbers = new ArrayList<>();

            for (String line : allLinesFromInput) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int helper = Integer.parseInt(number);
                    if ((helper % 2 == 0 && numbers.length % 2 == 0) || (helper % 2 == 1 && numbers.length % 2 != 0)) {
                        validNumbers.add(helper);
                    }
                }
            }
            System.out.println("Your output is " + validNumbers);
        } catch (IOException e) {
            throw new IOException("Error reading/writing files.", e);
        }
    }

    public static void readFromFileWriteToFile() throws IOException {
        try {
            Path inputFilePath = Path.of("input.txt");
            Path outputFilePath = Path.of("output.txt");
            List<String> allLinesFromInput = Files.readAllLines(inputFilePath);
            List<Integer> validNumbers = new ArrayList<>();

            for (String line : allLinesFromInput) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int helper = Integer.parseInt(number);
                    if ((helper % 2 == 0 && numbers.length % 2 == 0) || (helper % 2 == 1 && numbers.length % 2 != 0)) {
                        validNumbers.add(helper);
                    }
                }
            }
            
            String s = "";
            for (int x : validNumbers) {
                s = s.concat(String.valueOf(x) + " ");
            }
            Files.write(outputFilePath, s.getBytes());

        } catch (IOException e) {
            throw new IOException("Error reading/writing files.", e);
        }
    }
}



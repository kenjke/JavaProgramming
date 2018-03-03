package com.epam.aleksandr_generalov.java.lesson1.task2;

import java.util.*;

public class Task2Runner {

    private static final String rowsWord = "rows";
    private static final String wordsWord = "words";

    public static void main(String[] args) {
        Task2Runner runner = new Task2Runner();
        runner.startApplication();
    }

    private void startApplication() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter what do you want to enter: " + rowsWord + " - for rows, " + wordsWord + " -  for words");
            scanner.nextLine();
            String choice = scanner.nextLine();
            int n;
            String[] massiveForStrings;
            switch (choice) {
                case rowsWord:
                    System.out.println("Please enter number of rows:");
                    n = scanner.nextInt();
                    massiveForStrings = new String[n];
                    int sumOfLentgts = 0;
                    for (int i = 0; i < massiveForStrings.length; i++) {
                        massiveForStrings[i] = scanner.nextLine();
                        sumOfLentgts += massiveForStrings[i].length();
                    }
                    int average = sumOfLentgts / massiveForStrings.length;
                    System.out.println("Please enter action for rows: 1 - find all the the smallest and the biggest rows; " +
                            "2 - find all rows with length more than average; 3 - find all rows with length less than average");
                    int actionForRows = scanner.nextInt();
                    switch (actionForRows) {
                        case 1:
                            findAllTheSmallestAndBiggestRows(massiveForStrings);
                            break;
                        case 2:
                            findAllRowsWithLengthMoreThanAverage(massiveForStrings, average);
                            break;
                        case 3:
                            findAllRowsWithLengthLessThanAverage(massiveForStrings, average);
                            break;
                        default:
                            System.out.println("Please enter correct action!");
                            break;
                    }
                    break;
                case wordsWord:
                    System.out.println("Please enter number of words:");
                    n = scanner.nextInt();
                    massiveForStrings = new String[n];
                    for (int i = 0; i < massiveForStrings.length; i++) {
                        massiveForStrings[i] = scanner.nextLine();
                        if (massiveForStrings[i].split(" ").length > 1) {
                            System.out.println("Please enter single word in 1 row!");
                            return;
                        }
                    }
                    System.out.println("Please enter action for rows: 1 - find first word, for which count of different symbols is the least;" +
                            "2 - find first word, which contains only different symbols; 3 - find second word (first is the only one), which contains only digits");
                    int actionForWords = scanner.nextInt();
                    switch (actionForWords) {
                        case 1:
                            List<Set<Character>> differentSymbols = findAllDifferentSymbols(massiveForStrings, false);
                            int minimumOfDifferentSymbols = Integer.MAX_VALUE;
                            for (Set<Character> word : differentSymbols) {
                                if (word.size() < minimumOfDifferentSymbols && word.size() != 0) {
                                    minimumOfDifferentSymbols = word.size();
                                }
                            }
                            System.out.println("First word with minimum of different symbols: ");
                            for (int i = 0; i < massiveForStrings.length; i++) {
                                if (differentSymbols.get(i).size() == minimumOfDifferentSymbols) {
                                    System.out.println(massiveForStrings[i]);
                                    break;
                                }
                            }
                            break;
                        case 2:
                            differentSymbols = findAllDifferentSymbols(massiveForStrings, false);
                            System.out.println("First word with only different symbols: ");
                            for (int i = 0; i < massiveForStrings.length; i++) {
                                if (differentSymbols.get(i).size() == massiveForStrings.length) {
                                    System.out.println(massiveForStrings[i]);
                                    break;
                                }
                            }
                            break;
                        case 3:
                            differentSymbols = findAllDifferentSymbols(massiveForStrings, true);
                            System.out.println("Second word with only digits:");
                            String stringToPrint = null;
                            for (int i = 0; i < massiveForStrings.length; i++) {
                                if (differentSymbols.get(i).size() == massiveForStrings[i].length()
                                        && differentSymbols.get(i).size() != 0) {
                                    if (stringToPrint != null) {
                                        System.out.println(massiveForStrings[i]);
                                        return;
                                    } else {
                                        stringToPrint = massiveForStrings[i];
                                    }
                                }
                            }
                            if (stringToPrint != null) {
                                System.out.println(stringToPrint);
                            } else {
                                System.out.println("There are no words with criteria above!");
                            }
                            break;
                        default:
                            System.out.println("Please enter correct action!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Please enter correct action!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
    }

    private void findAllRowsWithLengthLessThanAverage(String[] massiveForStrings, int average) {
        System.out.println("Rows with length more than average: ");
        for (String row : massiveForStrings) {
            if (row.length() < average) {
                System.out.println(row + " : " + row.length());
            }
        }
    }

    private void findAllRowsWithLengthMoreThanAverage(String[] massiveForStrings, int average) {
        System.out.println("Rows with length more than average: ");
        for (String row : massiveForStrings) {
            if (row.length() > average) {
                System.out.println(row + " : " + row.length());
            }
        }
    }

    private void findAllTheSmallestAndBiggestRows(String[] massiveForStrings) {
        int min = Integer.MAX_VALUE;
        for (String row : massiveForStrings) {
            if (row.length() < min) {
                min = row.length();
            }
        }
        int max = Integer.MIN_VALUE;
        for (String row : massiveForStrings) {
            if (row.length() > max) {
                max = row.length();
            }
        }
        System.out.println("Rows with minimum and maximum lengths: ");
        for (String row : massiveForStrings) {
            if (row.length() == min || row.length() == max) {
                System.out.println(row + " : " + row.length());
            }
        }
    }

    private List<Set<Character>> findAllDifferentSymbols(String[] massiveForStrings, boolean isDigitsOnly) {
        List<Set<Character>> differentSymbols = new ArrayList<>();
        for (int i = 0; i < massiveForStrings.length; i++) {
            differentSymbols.add(new HashSet<Character>());
            for (int j = 0; j < massiveForStrings[i].length(); j++) {
                if (isDigitsOnly && massiveForStrings[i].charAt(j) > '0' && massiveForStrings[i].charAt(j) < '9') {
                    differentSymbols.get(i).add(massiveForStrings[i].charAt(j));
                } else {
                    differentSymbols.get(i).add(massiveForStrings[i].charAt(j));
                }
            }
        }
        return differentSymbols;
    }
}

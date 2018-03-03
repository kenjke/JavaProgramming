package com.epam.aleksandr_generalov.java.lesson1.task1;

import java.util.*;

public class Task1Runner {

    private static final int ELEMENT_COUNT = 20;

    public static void main(String[] args) {
        Task1Runner runner = new Task1Runner();
        runner.startApplication();
    }

    private void startApplication() {
        try {
            int[] arrayOfIntegers = new int[ELEMENT_COUNT];
            Random random = new Random();
            for (int i = 0; i < arrayOfIntegers.length; i++) {
                arrayOfIntegers[i] = random.nextInt(ELEMENT_COUNT + 1) - (ELEMENT_COUNT / 2);
            }
            System.out.print("Source array: ");
            printArray(arrayOfIntegers);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter action: 1 - find maximum negative number and minimum positive number; 2 - " +
                    "sum of elements on even indexes; 3 - replace negative numbers to 0; 4 - multiply by 3 positive numbers, " +
                    "which stay before negative numbers; 5 - difference between average number and minimal element of the array;" +
                    "6 - print all elements, which meet more than once and stay on odds indexes");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    findMaxNegativeAndMinPositiveNumbers(arrayOfIntegers);
                    break;
                case 2:
                    findSumOfElementsOnEvenIndexes(arrayOfIntegers);
                    break;
                case 3:
                    replaceNegativeNumbersToZero(arrayOfIntegers);
                    break;
                case 4:
                    multiplyByThreePostivieNumbersBeforeNegativeNumbers(arrayOfIntegers);
                    break;
                case 5:
                    findDifferenceBetweenAverageAndMinimalElements(arrayOfIntegers);
                    break;
                case 6:
                    printAllElementsWhichMeetMoreThanOnceAndStayOnOddsIndexes(arrayOfIntegers);
                    break;
                default:
                    System.out.println("Please enter correct action!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
    }

    private void printAllElementsWhichMeetMoreThanOnceAndStayOnOddsIndexes(int[] arrayOfIntegers) {
        Map<Integer, Set<Integer>> countOfElements = new HashMap<>();
        for (int i = 0; i <= arrayOfIntegers.length; i++) {
            countOfElements.put(i - 10, new HashSet<Integer>());
        }
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            countOfElements.get(arrayOfIntegers[i]).add(i);
        }
        System.out.print("Elements, which persists in array more that once and only on odds indexes: ");
        for (Map.Entry<Integer, Set<Integer>> entry : countOfElements.entrySet()) {
            if (entry.getValue().size() > 1) {
                boolean isOddOnly = true;
                for (int index : entry.getValue()) {
                    if (index % 2 == 0) {
                        isOddOnly = false;
                        break;
                    }
                }
                if (isOddOnly) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }

    private void findDifferenceBetweenAverageAndMinimalElements(int[] arrayOfIntegers) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int integer : arrayOfIntegers) {
            sum += integer;
            if (min > integer) {
                min = integer;
            }
        }
        int average = sum / arrayOfIntegers.length;
        System.out.println("Difference between average = " + (sum / arrayOfIntegers.length) + " and minimum element = " +
                min + " is " + (average - min));
    }

    private void multiplyByThreePostivieNumbersBeforeNegativeNumbers(int[] arrayOfIntegers) {
        for (int i = 0; i < arrayOfIntegers.length - 1; i++) {
            if (arrayOfIntegers[i + 1] < 0 && arrayOfIntegers[i] > 0) {
                arrayOfIntegers[i] *= 3;
            }
        }
        System.out.println("Changed array: ");
        printArray(arrayOfIntegers);
    }

    private void replaceNegativeNumbersToZero(int[] arrayOfIntegers) {
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] < 0) {
                arrayOfIntegers[i] = 0;
            }
        }
        System.out.print("Changed array: ");
        printArray(arrayOfIntegers);
    }

    private void findSumOfElementsOnEvenIndexes(int[] arrayOfIntegers) {
        int sumOfEvenIndexesElements = 0;
        for (int i = 0; i < arrayOfIntegers.length; i += 2) {
            sumOfEvenIndexesElements += arrayOfIntegers[i];
        }
        System.out.println("Sum of even indexes elements is " + sumOfEvenIndexesElements);
    }

    private void findMaxNegativeAndMinPositiveNumbers(int[] arrayOfIntegers) {
        int minimumPositiveIndex = Integer.MAX_VALUE, maximumNegativeIndex = Integer.MIN_VALUE,
                minimumPositiveNumber = Integer.MAX_VALUE, maximumNegativeNumber = Integer.MIN_VALUE;
        for (int i = 0; i < arrayOfIntegers.length; i++) {
            if (arrayOfIntegers[i] < 0 && arrayOfIntegers[i] > maximumNegativeNumber) {
                maximumNegativeIndex = i;
                maximumNegativeNumber = arrayOfIntegers[i];
            } else if (arrayOfIntegers[i] > 0 && arrayOfIntegers[i] < minimumPositiveNumber) {
                minimumPositiveIndex = i;
                minimumPositiveNumber = arrayOfIntegers[i];
            }
        }
        System.out.println("Changed indexes: minimum positive is " + minimumPositiveIndex + " maximum negative is "
                + maximumNegativeIndex + ".");
        int temporaryVariable = arrayOfIntegers[minimumPositiveIndex];
        arrayOfIntegers[minimumPositiveIndex] = arrayOfIntegers[maximumNegativeIndex];
        arrayOfIntegers[maximumNegativeIndex] = temporaryVariable;
        System.out.print("Changed array: ");
        printArray(arrayOfIntegers);
    }

    private void printArray(int[] arrayOfIntegers) {
        for (int integer : arrayOfIntegers) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}

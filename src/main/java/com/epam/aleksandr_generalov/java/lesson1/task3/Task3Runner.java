package com.epam.aleksandr_generalov.java.lesson1.task3;

import java.util.Scanner;

public class Task3Runner {

    public static void main(String[] args) {
        Task3Runner runner = new Task3Runner();
        runner.startApplication();
    }

    private void startApplication() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter first number:");
            int a = scanner.nextInt();
            System.out.println("Please enter second number:");
            int b = scanner.nextInt();
            System.out.println("Please enter action: 1 - sum, 2 - subtract, 3 - multiply, 4 - divide");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println((a + b));
                    break;
                case 2:
                    System.out.println((a - b));
                    break;
                case 3:
                    System.out.println((a * b));
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Division by zero!");
                        return;
                    } else {
                        System.out.println(((float) a / b));
                    }
                    break;
                default:
                    System.out.println("Enter correct action!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }
    }
}

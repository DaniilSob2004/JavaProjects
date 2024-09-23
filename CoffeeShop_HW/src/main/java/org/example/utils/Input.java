package org.example.utils;

import java.util.Scanner;

public class Input {
    public static int inputInteger(String text, String errText, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.print(text);
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка, введите целое число...");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number < min || number > max) {
                System.out.println(errText);
            }
        } while (number < min || number > max);

        scanner.nextLine();
        return number;
    }

    public static double inputDouble(String text, String errText, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double number;

        System.out.print(text);
        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Ошибка, введите дробное число...");
                scanner.next();
            }
            number = scanner.nextDouble();
            if (number < min || number > max) {
                System.out.println(errText);
            }
        } while (number < min || number > max);

        scanner.nextLine();
        return number;
    }

    public static String inputString(String text, String errText) {
        Scanner scanner = new Scanner(System.in);
        String str;

        System.out.print(text);
        do {
            str = scanner.nextLine();
            if (str.isEmpty()) {
                System.out.println(errText);
            }
        } while (str.isEmpty());

        return str;
    }
}

package com.company;

import java.util.Scanner;

public class InputData {
    public static int inputIntNumber(String message, String errorMessage) {
        Scanner input = new Scanner(System.in);
        int value = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(message);
                value = input.nextInt();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(errorMessage);
                input.next();  // очищаем последний символ
            }
        }
        return value;
    }

    public static float inputFloatNumber(String message, String errorMessage) {
        Scanner input = new Scanner(System.in);
        float value = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(message);
                value = input.nextFloat();
                isValid = true;
            } catch (Exception ex) {
                System.out.println(errorMessage);
                input.next();  // очищаем последний символ
            }
        }
        return value;
    }
}

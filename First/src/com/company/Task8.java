package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Показать на экран таблицу умножения в диапазоне, указанном пользователем
 */
public class Task8 {
    public static int MAX_VALUE = 10;

    public static void main(String[] args) {
        int num1 = inputIntNumber("First num for arr: ", "Invalid number...");
        int num2 = inputIntNumber("Second num for arr: ", "Invalid number 2 ...");

        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        for (int i = num1; i <= num2; i++) {
            for (int j = 1; j <= MAX_VALUE; j++) {
                System.out.print(i + " * " + j + " = " + i * j + " | ");
            }
            System.out.println("\n------------------");
        }
    }
}

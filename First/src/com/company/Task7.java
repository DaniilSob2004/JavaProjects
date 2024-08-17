package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Пользователь вводит с клавиатуры два числа.
 Нужно показать все нечетные числа в указанном диапазоне.
 Если границы диапазона указаны неправильно требуется произвести нормализацию границ
 */
public class Task7 {
    public static void main(String[] args) {
        int num1 = inputIntNumber("First num for arr: ", "Invalid number...");
        int num2 = inputIntNumber("Second num for arr: ", "Invalid number 2 ...");

        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        for (int i = num1; i <= num2; i++) {
            if (i % 2 != 0) {
                System.out.print(i);
                if (i < num2 - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

    /*public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }*/
}

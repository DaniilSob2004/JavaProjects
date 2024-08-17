package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputIntNumber;

/**
 Пользователь вводит с клавиатуры три цифры.
 Необходимо создать число, содержащее эти цифры.
 */
public class Task3 {
    public static void main(String[] args) {
        float num1 = inputIntNumber("Input int number 1: ", "Invalid input number 1 ...");
        float num2 = inputIntNumber("Input int number 2: ", "Invalid input number 2 ...");
        float num3 = inputIntNumber("Input int number 3: ", "Invalid input number 3 ...");

        int result = (int)((num1 * 100) + (num2 * 10) + num3);
        System.out.println("The result: " + result);
    }
}

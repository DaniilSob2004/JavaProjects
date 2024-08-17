package com.company;

// импорт моего static класса для ввода данных
import static com.company.InputData.inputFloatNumber;

/**
 Пользователь вводит с клавиатуры два числа.
 Первое число — это значение, второе число процент, который необходимо посчитать
 */
public class Task2 {
    public static void main(String[] args) {
        float number = inputFloatNumber("Input number: ", "Invalid input number...");
        float percent = inputFloatNumber("Input percent: ", "Invalid input percent...");

        float result = number * (percent / 100);
        System.out.println("The result: " + result);
    }
}

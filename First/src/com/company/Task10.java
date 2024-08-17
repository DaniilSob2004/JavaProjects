package com.company;

import java.util.Random;
import java.util.function.Predicate;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 Есть одномерный массив, заполненный случайными числами.
 На основании данных этого массива нужно:
   - Создать одномерный массив, содержащий только четные числа из первого массива
   - Создать одномерный массив, содержащий только нечетные числа из первого массива
   - Создать одномерный массив, содержащий только отрицательные числа из первого массива
   - Создать одномерный массив, содержащий только положительные числа из первого массива
 */
public class Task10 {
    public static int SIZE_ARR = 10;
    public static int MIN_RAND_NUM = -100;
    public static int MAX_RAND_NUM = 100;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[SIZE_ARR];

        for (int i = 0; i < SIZE_ARR; i++) {
            arr[i] = rand.nextInt(MIN_RAND_NUM, MAX_RAND_NUM);
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nEven array: " + Arrays.toString(createEvenNumberArray(arr)));
        System.out.println("Odd array: " + Arrays.toString(createOddNumberArray(arr)));
        System.out.println("Negative array: " + Arrays.toString(createNegativeNumberArray(arr)));
        System.out.println("Positive array: " + Arrays.toString(createPositiveNumberArray(arr)));

    }

    public static int[] createArrayByAnotherArray(int[] arr, Predicate<Integer> condition) {
        List<Integer> filteredList = new ArrayList<>();

        for (int i : arr) {
            if (condition.test(i)) {
                filteredList.add(i);
            }
        }

        int[] newArr = new int[filteredList.size()];
        for (int i = 0; i < filteredList.size(); i++) {
            newArr[i] = filteredList.get(i);
        }

        return newArr;
    }

    public static int[] createEvenNumberArray(int[] arr) {
        return createArrayByAnotherArray(arr, e -> e % 2 == 0);
    }

    public static int[] createOddNumberArray(int[] arr) {
        return createArrayByAnotherArray(arr, e -> e % 2 != 0);
    }

    public static int[] createNegativeNumberArray(int[] arr) {
        return createArrayByAnotherArray(arr, e -> e < 0);
    }

    public static int[] createPositiveNumberArray(int[] arr) {
        return createArrayByAnotherArray(arr, e -> e > 0);
    }
}

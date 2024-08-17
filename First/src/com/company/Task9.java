package com.company;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 В одномерном массиве, заполненном случайными числами определить:
   - минимальный и максимальный элементы,
   - посчитать количество отрицательных элементов,
   - посчитать количество положительных элементов,
   - посчитать количество нулей
 */
public class Task9 {
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

        System.out.println("\nMin value: " + minElemArray(arr));
        System.out.println("Max value: " + maxElemArray(arr));

        System.out.println("Count negative: " + countNegative(arr));
        System.out.println("Count positive: " + countPositive(arr));
        System.out.println("Count zero: " + countZero(arr));
    }


    public static int countElements(int[] arr, Predicate<Integer> condition) {
        if (arr.length < 0) {
            return 0;
        }

        int result = 0;
        for (int i : arr) {
            if (condition.test(i)) {
                result++;
            }
        }
        return result;
    }

    public static int countNegative(int[] arr) {
        return countElements(arr, a -> a < 0);
    }

    public static int countPositive(int[] arr) {
        return countElements(arr, a -> a > 0);
    }

    public static int countZero(int[] arr) {
        return countElements(arr, a -> a == 0);
    }


    public static int findElement(int[] arr, BiPredicate<Integer, Integer> condition) {
        if (arr.length < 0) {
            return 0;
        }

        int result = arr[0];
        for (int i : arr) {
            if (condition.test(arr[i], result)) {
                result = arr[i];
            }
        }
        return result;
    }

    public static int minElemArray(int[] arr) {
        return findElement(arr, (a, b) -> a < b);
    }

    public static int maxElemArray(int[] arr) {
        return findElement(arr, (a, b) -> a > b);
    }
}

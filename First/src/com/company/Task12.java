package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 Напишите метод, сортирующий массив по убыванию или возрастанию в зависимости от выбора пользователя
 */
public class Task12 {
    public enum MoveSort {
        ASC,
        DESC
    }

    public static int SIZE_ARR = 10;
    public static int MIN_RAND_NUM = -100;
    public static int MAX_RAND_NUM = 100;

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[SIZE_ARR];

        for (int i = 0; i < SIZE_ARR; i++) {
            arr[i] = rand.nextInt(MIN_RAND_NUM, MAX_RAND_NUM);
        }
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr, MoveSort.DESC);
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr, MoveSort.ASC);
        System.out.println(Arrays.toString(arr));
    }

    // Bubble sort
    public static void bubbleSort(int[] arr, MoveSort moveSort) {
        boolean isSwapped;

        for (int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ((moveSort == MoveSort.ASC && arr[j] > arr[j + 1]) ||
                    (moveSort == MoveSort.DESC && arr[j] < arr[j + 1])) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }
}

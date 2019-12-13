package com.lesson9;

import java.util.Arrays;
import java.util.Random;

/*
        2) Заполнить массив случайными числами. Подсчитать:
        - количество элементов которые больше своего соседа слева
        - количество четных элементов
        - количество элементов которые меньше среднего арифметического
        */
public class task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(100)];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        leftIsLesser(arr);
        indexIsEven(arr);
        isGreaterThanAvg(arr);

    }

    private static void isGreaterThanAvg(int[] arr) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int avg = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > avg) {
                count++;
            }
        }
        System.out.println("Элементов которые больше среднего арифм.");
        System.out.println(count + " из " + arr.length);
        System.out.println();
    }

    private static void leftIsLesser(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count++;
            }
        }
        System.out.println("Левый элемент - меньше");
        System.out.println(count + " из " + arr.length);
        System.out.println();
    }

    private static void indexIsEven(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println("Четных элементов");
        System.out.println(count + " из " + arr.length);
        System.out.println();
    }

}

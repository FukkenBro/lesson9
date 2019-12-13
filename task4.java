package com.lesson9;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*

        4*) Заполнить массив случайными числами. Создать массив который в N раза больше исходного и N раз продублировать в нем исходный массив.
        Например: был массив [1,2,3] и N=2 => [1,2,3,1,2,3]
        5*) Написать метод который ищет при помощи бинарного поиска есть ли число в массиве.
        Параметры - отсортированный массив и число которое надо проверить. Результат типа boolean.
        6*) Подсчитать количество треугольников, у которых стороны заданы целыми числами, и площадь которых не больше 100.
        6.1*) Сделать задание так чтобы не было повторяющихся треугольников, например (3,4,5) и (5,3,4) - повторяющиеся.*/
public class task4 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(5) + 3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите N");
        int n = scanner.nextInt();
        System.out.println(n);
        int[] result = new int[arr.length * n];
        for (int i = 0, j = 0; j < result.length; i++, j++) {
            result[j] = arr[i];
            if (i == arr.length - 1) {
                i = -1;
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.println("Или");
        int[] alternativeResult = new int[arr.length * n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr, 0, alternativeResult, arr.length * i, arr.length);
        }
        System.out.println(Arrays.toString(alternativeResult));
    }

}

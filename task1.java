package com.lesson9;

/*      1) Создать enum который отображает вид сортировки, например enum SortType { BUBBLE, INSERT, SELECT }.
        Написать метод который принимает массив и переменную типа enum и сортирует выбранным типом сортировки, например: sort(arr, SortType.INSERT);
       */

import java.util.Random;

public class task1 {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        for (sortMethod arg : sortMethod.values()) {
            sort(arr, arg);
        }

    }

    private static void sort(int[] arr, sortMethod arg) {

        switch (arg) {
            case BUBBLE:
                System.out.println("BUBBLE");
                bubbleSort(arr);
                break;
            case INSERTION:
                System.out.println("INSTERION");
                insterionSort(arr);
                break;
            case SELECT:
                System.out.println("SELECTION");
                selectionSort(arr);
                break;
        }

    }

    enum sortMethod {
        BUBBLE,
        INSERTION,
        SELECT;
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
    }

    private static void insterionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static void selectionSort(int arr[]) {
        int n = arr.length;
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

}


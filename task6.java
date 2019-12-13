package com.lesson9;

import java.util.Arrays;

/*
        6*) Подсчитать количество треугольников, у которых стороны заданы целыми числами, и площадь которых не больше 100.
        6.1*) Сделать задание так чтобы не было повторяющихся треугольников, например (3,4,5) и (5,3,4) - повторяющиеся.*/
public class task6 {

    // В целях оптимизации результаты одноразовых расчётов не пересчитыаются при каждом запуске программы а внесены в неё в качестве констант.
    // Эксперементально установленно что наибольшее целое значение для длинны грани у треугольника с площадью S<=100 составляет 115 ед.

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,};

    public static void main(String[] args) {
        driver();
    }

    private static void driver() {
        double[] uniqueAreas = new double[500];
        double[] uniquePerimeters = new double[500];
        int count = 0;
        double area = 0;
        int[] triangle = new int[]{PRIMES[0], PRIMES[1], PRIMES[2]};
        for (int a = 0, b = 0, c = 0; triangle[0] != PRIMES[PRIMES.length - 1]; c++) {
            triangle[0] = PRIMES[a];
            triangle[1] = PRIMES[b];
            triangle[2] = PRIMES[c];
            if (checkIfReal(triangle) == true) {
                area = area(triangle);
                double perimeter = triangle[0] + triangle[1] + triangle[2];
                if (area <= 100) {

                    if (checkIfUniqe(uniqueAreas, uniquePerimeters, area, perimeter) == true) {
                        System.out.println(Arrays.toString(triangle));
                        count++;
                        uniqueAreas[count] = area;
                        uniquePerimeters[count] = perimeter;
                    }
                    continue;
                }
            }
            if (triangle[2] == PRIMES[PRIMES.length - 1]) {
                c = -1;
                b++;
            }
            if (triangle[1] == PRIMES[PRIMES.length - 1]) {
                b = 0;
                a++;
            }
        }
        System.out.println("Ответ " + count + " треугольников");

    }

    private static boolean checkIfUniqe(double[] uniqueAreas, double[] uniquePerimeters, double area, double perimeter) {
        //Исходя из формулы Герона два разных треугольника с одинаковой площадью возможно, поэтому проверяем уникальность так же и по их периметру.
        //funfact исходя из результатов там таки было 2 треугольника с абсолютно одинаковой площадью но разными сторонами

        boolean dupeArea = false;
        boolean dupePerimeter = false;

        for (int i = 0; i < uniqueAreas.length; i++) {
            for (int j = i + 1; j < uniqueAreas.length; j++) {
                if (j != i && uniqueAreas[j] == area) {
                    dupeArea = true;
                }
            }
        }
        for (int i = 0; i < uniquePerimeters.length; i++) {
            for (int j = i + 1; j < uniquePerimeters.length; j++) {
                if (j != i && uniquePerimeters[j] == perimeter) {
                    dupePerimeter = true;
                }
            }
        }
        if (dupeArea == true && dupePerimeter == true) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkIfReal(int[] triangle) {
        if (triangle[0] + triangle[1] > triangle[2] && triangle[1] + triangle[2] > triangle[0] && triangle[0] + triangle[2] > triangle[1]) {
            return true;
        } else {
            return false;
        }
    }

    private static double area(int[] triangle) {
        double sum = 0;
        for (int i = 0; i < triangle.length; i++) {
            sum += triangle[i];
        }
        double p = sum / 2;
        double area = Math.sqrt(p * (p - triangle[0]) * (p - triangle[1]) * (p - triangle[2]));
        return area;
    }


}
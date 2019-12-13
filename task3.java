package com.lesson9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
        3) Попросить пользователя ввести строку и имя файла. Записать строку в файл.
        */
public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task3.txt"))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

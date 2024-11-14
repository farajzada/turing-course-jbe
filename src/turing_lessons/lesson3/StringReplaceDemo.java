package turing_lessons.lesson3;

import java.util.Scanner;

public class StringReplaceDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        System.out.println(str.replaceAll("[a-zA-Z0-9]", "-"));
    }
}

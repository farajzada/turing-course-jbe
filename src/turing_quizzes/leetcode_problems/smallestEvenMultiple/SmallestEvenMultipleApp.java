package turing_quizzes.leetcode_problems.smallestEvenMultiple;

import java.util.Scanner;

public class SmallestEvenMultipleApp {
    public static int smallestPositive(int num) {
        return num % 2 == 0 ? num : 2 * num;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Enter value: ");
        n = scanner.nextInt();
        System.out.println("Smallest : " + n + " and 2 : " + smallestPositive(n));
    }
}

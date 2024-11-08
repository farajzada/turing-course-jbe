package turing_quizzes.leetcode_problems.fibonacciNumbers;

import java.util.Scanner;

public class FibonacciApp {
    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int sum = a + b;
        while (N > 1) {
            sum = a + b;
            a = b;
            b = sum;
            N--;

        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int fib = fib(num);
        System.out.println(fib);
    }
}

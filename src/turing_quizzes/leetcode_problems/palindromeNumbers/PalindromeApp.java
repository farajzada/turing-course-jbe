package turing_quizzes.leetcode_problems.palindromeNumbers;

import java.util.Scanner;

public class PalindromeApp {

    public static boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0)
            return false;

        // reverse process
        int reversed = 0;
        int originalNum = x;

        while (x != 0) {
            reversed = reversed * 10 + x % 10; // x = 121,12,1 reversed = 1,12,121
            x = x / 10;
        }
        return reversed == originalNum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(isPalindrome(number));
    }


}

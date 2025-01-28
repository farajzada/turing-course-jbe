package turing_lessons.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);

        }

        System.out.println("Before sorting: " + Arrays.toString(arr));

        for (int i = 0; i < n - 1; i++) {
           for (int eee = i; eee < n; eee++) {
               if (arr[i] > arr[eee]) swap(arr,i, eee);
           }
        }
        System.out.println("After sorting: " + Arrays.toString(arr));
    }


    private static void swap(int[] arr, int i, int i1) {
        arr[i] += arr[i1];
        arr[i1] = arr[i] - arr[i1];
        arr[i] -= arr[i1];
    }
}

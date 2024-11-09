package turing_lessons.lesson1;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {

        int[] arr;
        arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        arr[6] = 7;
        arr[7] = 8;
        arr[8] = 9;
        arr[9] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("element at index " + i + ": " + arr[i]);
        }



        // cloning single dimension array
        int[] intArray = {1,2,3};
        int [] cloneArray = intArray.clone();
        System.out.println(intArray == cloneArray);


        for (int i = 0; i < cloneArray.length; i++) {
            System.out.println(cloneArray[i] + " ");
        }



        // cloning  multi dimensional array


        int[][] intArray2 = {{1,2,3},{4,5}};
        int[][] cloneArray2 = intArray2.clone();

        System.out.println(intArray2 == cloneArray2);

        System.out.println(intArray2[0] == cloneArray2[0]);
        System.out.println(intArray2[1] == cloneArray2[1]);

    }
}

package turing_classworks.classwork2;

import java.util.Arrays;
import java.util.Scanner;

public class BuildArrayFromPermutationApp {


    public static int[] buildArray(int[] nums) {
        int[] renew = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            renew[i] = nums[nums[i]];
        }
        return renew;
    }

    public static void main(String[] args) {

        int[] arr = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArray(arr)));


    }

}

package turing_lessons.lesson6;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
    public static void main(String[] args) {
        boolean flag = false;
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        for (int i : arr1) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        for (int i : countMap.values()) {
            countMap2.put(i, countMap2.getOrDefault(i, 0) + 1);
        }
        for (int count : countMap2.values()) {
            if (count > 1) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }
}

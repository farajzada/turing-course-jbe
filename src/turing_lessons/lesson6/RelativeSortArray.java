package turing_lessons.lesson6;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arrr1 = new int[1001];
        for (int i : arr1) {
            arrr1[i]++;
        }


        int[] arrr2 = new int[arr1.length];
        int i = 0;


        for (int n : arr2) {
            while (arr1[n] > 0) {
                arrr2[i] = n;
                arrr1[n]--;
                i++;
            }
        }


        for (int j = 0; j < arrr1.length; j++) {
            while (arrr1[j] > 0) {
                arrr2[i] = j;
                arrr1[j]--;
                i++;
            }
        }


        return arrr2;

    }

    public static void main(String[] args) {
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = relativeSortArray.relativeSortArray(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

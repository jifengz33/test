package com.sort2;

import java.util.Arrays;

/**
 * @author
 * @date 2020-01-04 14:46
 */
public class QuickSort {
    public static void main(String[] args) {
        //int arr[] = {20, 5, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        int[] arr = {0, 6, 1, 2, 7, 9, 19, 200, 11, 4, 5, 10, 8, 15, -1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = arr[start];
        int i = start;
        int j = end;
        int temp;
        while (i < j) {
            while (i < j && pivot <= arr[j]) {
                j--;
            }
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[start] = arr[i];
        arr[i] = pivot;
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);
    }
}

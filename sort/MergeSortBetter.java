package com.sort;

import java.util.Arrays;

/**
 * @author
 * @date 2020-01-11 9:48
 */
public class MergeSortBetter {

    public static void main(String[] args) {
        int arr[] = {8, 4, 7, 5, 3, 1, 6, 2}; //


        mergeSort(arr);

        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] helps = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            helps[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helps[i++] = arr[p1++];
        }
        while (p2 <= right) {
            helps[i++] = arr[p2++];
        }
        for (int j = 0; j < helps.length; j++) {
            arr[left + j] = helps[j];
        }
    }
}


